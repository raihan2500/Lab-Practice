package multiThreading.theory;

public class JoinMethod {

    static Runnable task = ()->{
        for(int i = 0; i < 100; i++){
            System.out.println("This is task");
        }
    };

    public static void main(String[] args) throws Exception {
        Thread t4 = new Thread(() ->{
            for(int i = 0; i < 100; i++){
                System.out.println("Thread4 running");
            }
        });

        t4.start();
        try {
            t4.join(); //Here main thread will stop until t4 complete
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        t4.start(); //This is an Exception because thread can run only one time

        Thread t1 = new Thread(task);
        t1.start();
        System.out.println("Hello");
    }
}
