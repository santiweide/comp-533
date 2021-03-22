package comp533.a2.model;

import comp533.a2.model.barrier.Barrier;
import comp533.a2.model.barrier.IBarrier;
import comp533.a2.model.joiner.IJoiner;
import comp533.a2.model.joiner.Joiner;
import comp533.a2.model.mapper.IMapper;
import comp533.a2.model.mapper.MapperFactory;
import comp533.a2.model.reducer.IReducer;
import comp533.a2.model.reducer.ReducerFactory;
import comp533.a2.model.slave.Slave;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;
import org.checkerframework.checker.units.qual.K;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class TokenCountingModel extends AMapReduceTracer implements IModel {
    private String inputString;
    private Map<String, Integer> output;
    private PropertyChangeSupport support;

    private int numThreads;
    private List<Thread> threads;
    /**
     * A single queue is used for all rounds of input.
     */
    private BlockingQueue<KeyValue> bufferQueue;

    /**
     * Its elements are instances of Java’s LinkedList, which is essentially a non-blocking queue.
     * We will refer to each LinkedList element of this list as a reduction queue. Like the bounded buffer above,
     * a reduction queue will collect Key-Value instances.
     */
    private List<LinkedList<KeyValue>> reductionQueueList;

    private IJoiner joiner;
    private IBarrier barrier;

    public TokenCountingModel() {
        output = new HashMap<>();
        support = new PropertyChangeSupport(this);
        threads = new ArrayList<>();
        bufferQueue = new ArrayBlockingQueue<>(BUFFER_SIZE);
        reductionQueueList = new ArrayList<>();
        joiner = new Joiner(numThreads);
        barrier = new Barrier(numThreads);
    }

    @Override
    public void setInputString(String inputString) {
        //1.    Initialization of next round of token processing:
        output.clear();
        for(LinkedList list :reductionQueueList){
            list.clear();
        }
        // 2.	Possible unblocking of slave threads
        for(Thread thread:threads){
            thread.notify();
        }
        // 3.	Problem split
        support.firePropertyChange("InputString", this.inputString, inputString);
        this.inputString = inputString;
        String[] inputs = this.inputString.split(" ");
        IMapper mapper = MapperFactory.getMapper();

        IReducer reducer = ReducerFactory.getReducer();
        for (String input : inputs) {
            KeyValue kv = mapper.map(input);
            this.traceMap(input, kv);
            // 4.	Bounded buffer production:
            try {
                bufferQueue.put(kv);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 5.	End of input enqueue:
        for(int i = 0;i < numThreads;i ++){
            bufferQueue.add(new KeyValue(null, null));
        }
        // 6.   Join
        joiner.join();
        //---------- here begins the slaves -----------------
        for(Thread thread:threads){
            thread.start();
        }

        // 7.	Merge partitioned results serially
        //  It serially combines into the Result property the slaves’  final reductions of their partitions in the reduction queue list..

        // Map newOutput = reducer.reduce(list);
        // this.traceReduce(list, newOutput);
        // 8.	It announces a change to the Result property to its observers.
//        support.firePropertyChange("Result", output, newOutput);
//        output = newOutput;
    }

    public Map<String, Integer> getOutput() {
        return output;
    }


    @Override
    public String toString() {
        return "Model";
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.support.addPropertyChangeListener(listener);
    }


    public int getNumThreads() {
        return numThreads;
    }

    @Override
    public void setNumThreads(int numThreads) {
        // Thread Poool
        //The NumThreads setter creates the required number of slave threads.
        // It passes to the constructor of each slave runnable class a unique number in the range 0..Num Threads,
        // which will be called the slave number of the thread that executes this runnable.
        // It  passes to the  slave constructor the model (this). It sets the name of the thread to be “Slave<SlaveNumber>”.
        support.firePropertyChange("NumThreads", this.numThreads, numThreads);
        this.numThreads = numThreads;
        List<Thread> newList = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            Thread t = new Thread(new Slave());
            t.setName("Slave<" + i + ">");
            newList.add(new Thread(t));
            // add a separate reduction queue to the ReductionQueueList for each slave thread.
            reductionQueueList.add(new LinkedList<>());
        }
        support.firePropertyChange("Threads", this.threads, newList);
        threads = newList;

    }

    public List<Thread> getThreads() {
        return threads;
    }


}
