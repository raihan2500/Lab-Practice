package multiThreading;

class MyRunable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunable is running");
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread is running");
    }
}


public class Ways {
    public static void main(String[] args) {
        Runnable r = new MyRunable();
        Thread t1 = new Thread(r);

        r.run(); //Running in Main thread

        t1.start(); //Thread 1 started

        MyThread t2 = new MyThread();
        t2.start(); //Thread 2 started

        MyThread t3 = new MyThread();
        t3.start();

        Thread t4 = new Thread(() ->{
            for(int i = 0; i < 100; i++){
                System.out.println("Thread4 running");
            }
        });

        t4.start();
        try {
            t4.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello");
    }
}
