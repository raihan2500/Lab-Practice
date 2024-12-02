package multiThreading;

import java.util.Date;

public class Ajaira  {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for(int i = 1; i <= 100; i++){
                Date now = new Date();
                System.out.println(now + " Hello" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t1.join();

        for(int i = 0; i < 100; i++){
            System.out.println("Main func " + (i + 1));
            Thread.sleep(100);
        }
    }
}
