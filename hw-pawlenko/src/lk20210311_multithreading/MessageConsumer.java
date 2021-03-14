package lk20210311_multithreading;

public class MessageConsumer implements Runnable {

    private SingleItemQueue queue;

    public MessageConsumer(SingleItemQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String s = queue.removeLast();
                System.out.println(s);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
