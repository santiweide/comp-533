package comp533.a2.model.slave;

public class Slave implements ISlave {
    @Override
    public synchronized void notifySlave() {
        this.notify();
    }

    @Override
    public void run() {

    }
}
