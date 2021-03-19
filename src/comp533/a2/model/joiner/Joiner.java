package comp533.a2.model.joiner;

/**
 * @author algorithm
 */
public class Joiner implements IJoiner {
    int count;
    int nowCount;

    /**
     * @param count how many threads will call finished()
     */
    public Joiner(int count) {
        this.count = count;
        nowCount = 0;
    }

    @Override
    public synchronized void finished() {
        nowCount ++;
    }

    @Override
    public synchronized void join() {
        System.out.println(Thread.currentThread().getName() + " : " + nowCount);
        try {
            if(nowCount == count){
                for(int i = 0;i < count;i ++){
                    notify();
                }
                nowCount = 0;
            } else {
                wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
