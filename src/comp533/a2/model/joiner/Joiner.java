package comp533.a2.model.joiner;

/**
 * @author algorithm
 */
public class Joiner implements IJoiner {
    int count;
    int finishCount;
    int waitCount;

    /**
     * @param count how many threads will call finished()
     */
    public Joiner(int count) {
        this.count = count;
        finishCount = 0;
        waitCount = 0;
    }

    @Override
    public synchronized void finished() {
        System.out.println("finish"+" "+Thread.currentThread().getName() + " : " + finishCount +":"+waitCount);
        finishCount ++;
        if(waitCount !=0 && finishCount >= count){
            notify();
            waitCount --;
        }
    }

    @Override
    public synchronized void join() {
        System.out.println("join" + " "+Thread.currentThread().getName() + " : " + finishCount +":"+waitCount);
        try {
            if(finishCount >= count){
                for(int i = 0;i < finishCount;i ++){
                    notify();
                }
                finishCount = 0;
                waitCount = 0;
            } else {
                waitCount ++;
                wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
