package multiThreading.practiceExcercise;

import java.util.LinkedList;
import java.util.Random;

public class E1 {
    private static final LinkedList<Integer> list = new LinkedList<>();
    private static final Random rand = new Random();

    public static void main(String[] args) {

        Thread adder = new Thread(() -> {

            for(int i = 0; i < 1000; i++){
                synchronized (list){
                    list.add(rand.nextInt(1000));
                    System.out.println("Added: " + i);
                }

                try {
                    Thread.sleep(rand.nextInt(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread remover = new Thread(() -> {
            for(int i = 0; i < 1000; i++){
                synchronized (list){
                    if(!list.isEmpty()){
                        list.removeFirst();
                        System.out.println("Remove: " + i);
                    }
                }
                try {
                    Thread.sleep(rand.nextInt(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        adder.start();
        remover.start();

        try {
            adder.join();
            remover.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final size: " + list.size());
    }
}
