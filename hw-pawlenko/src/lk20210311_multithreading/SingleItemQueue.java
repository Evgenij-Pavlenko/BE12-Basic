package lk20210311_multithreading;

public class SingleItemQueue {
    private String content;
    private final Object mutex = new Object();

    public void addFirst(String input) {
        synchronized (mutex) {
            content = input;
            mutex.notify();
        }
    }

    public String removeLast() throws InterruptedException {
        synchronized (mutex) {
            while (content == null){

                System.out.println("The thread with id " + Thread.currentThread().getName() + " fall asleep");
                mutex.wait();
            }
        }
        System.out.println("The thread with id " + Thread.currentThread().getName() + " woke up");
        String ret = content;
        content = null;
        return ret;

    }
}
