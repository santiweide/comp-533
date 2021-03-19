package comp533.a2.model;

import comp533.a2.model.mapper.IMapper;
import comp533.a2.model.mapper.MapperFactory;
import comp533.a2.model.reducer.IReducer;
import comp533.a2.model.reducer.ReducerFactory;
import gradingTools.comp533s19.assignment0.AMapReduceTracer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TokenCountingModel extends AMapReduceTracer implements IModel {
    private String inputString;
    private Map<String, Integer> output;
    private PropertyChangeSupport support;

    private int numThreads;
    private List<Thread> threads;

    public TokenCountingModel() {
        output = new HashMap<>();
        support = new PropertyChangeSupport(this);
        threads = new ArrayList<>();
    }

    @Override
    public void setInputString(String inputString) {
        support.firePropertyChange("InputString",this.inputString, inputString);
        this.inputString = inputString;
        String[] inputs = this.inputString.split( " ");
        IMapper mapper = MapperFactory.getMapper();
        IReducer reducer = ReducerFactory.getReducer();
        List<KeyValue> list = new ArrayList();
        for(String input:inputs){
            KeyValue kv = mapper.map(input);
            this.traceMap(input, kv);
            list.add(kv);
        }
        Map newOutput = reducer.reduce(list);
        this.traceReduce(list, newOutput);
        support.firePropertyChange("Result", output, newOutput);
        output = newOutput;
    }

    public Map<String, Integer> getOutput() {
        return output;
    }


    @Override
    public String toString(){
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
        support.firePropertyChange("NumThreads",this.numThreads, numThreads);
        this.numThreads = numThreads;
        List<Thread> newList = new ArrayList<>();
        for(int i = 0;i < numThreads; i ++){
            newList.add(new Thread("Slave<"+ i +">"));
        }
        support.firePropertyChange("Threads", this.threads, newList);
        threads = newList;
    }

    public List<Thread> getThreads() {
        return threads;
    }


}
