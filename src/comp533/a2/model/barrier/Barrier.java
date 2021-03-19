package comp533.a2.model.barrier;

public class Barrier implements IBarrier {
    int count;
    int nowCount;
    /**
     *
     * @param count similar to waitGroup(count)
     */
    public Barrier(int count){
        this.count = count;
        nowCount = 0;
    }


    @Override
    public synchronized void barrier(){
        nowCount ++;
        try {
            if(nowCount == count){
                notifyAll();
                nowCount = 0;
            } else {
                wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
