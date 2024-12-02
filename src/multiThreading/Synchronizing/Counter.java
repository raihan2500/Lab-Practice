package multiThreading.Synchronizing;

public class Counter {
    public int c = 0;

    //Here synchronized prevent two thread to call the function at same time
    public synchronized void increment(){
        c++;
    }
}

