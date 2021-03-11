package hw20210309_race;

import java.util.concurrent.TimeUnit;

public class StopThread {
    public static boolean stopRequested;
    // or:
//    public static volatile boolean stopRequested;

    public static synchronized void requestStop(){
        stopRequested = true;
    }

    public static synchronized boolean stopRequested(){
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(!stopRequested()){
                    i++;
                }
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("Requestng background thread to stop!");
        requestStop();
    }
}
