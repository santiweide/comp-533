package comp533.a2.model.barrier;

public interface IBarrier {
    /**
     * Each call to this method should block until count number of calls to this method by different threads have been made.
     */
    void barrier();

}
