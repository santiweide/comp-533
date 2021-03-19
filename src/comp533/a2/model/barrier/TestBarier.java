package comp533.a2.model.barrier;

public class TestBarier {
    public static void main(String[] args){
        Barrier b = new Barrier(3);
        for(int i = 0;i < 3;i ++){
            System.out.println(i);
            new Thread(() -> {
                b.barrier();
            },String.valueOf(i)).start();

        }
    }
}
