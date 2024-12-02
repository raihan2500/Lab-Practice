package multiThreading.theory;

import java.util.Date;

public class GreetingRunnable implements Runnable{
    private String greeting;
    private int rep = 10;
    private  int delay = 200;

    public GreetingRunnable(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public void run() {
        try{
            for(int i = 1; i <= rep; i++){
                Date now = new Date();
                System.out.println(now + " " + greeting);
                Thread.sleep(delay);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
