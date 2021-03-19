package comp533.a2.model.joiner;

import comp533.a2.model.barrier.Barrier;

public class TestJoiner {
    public static void main(String[] args){
        Joiner b = new Joiner(3);
//        for(int i = 0;i < 3;i ++){
//            System.out.println(i);
//            new Thread(() -> {
//                b.finished();
//                b.join(); // late join
//            },String.valueOf(i)).start();
//        }
        for(int i = 0;i < 3;i ++){
            System.out.println(i);
            new Thread(() -> {
                b.join(); // early join
                b.finished();
            },String.valueOf(i)).start();
        }
    }
}
