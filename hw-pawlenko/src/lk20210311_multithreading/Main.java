package lk20210311_multithreading;

public class Main {

    public static void main(String[] args) {
        SingleItemQueue queue = new SingleItemQueue();

        Thread thread1 = new Thread(new MessageConsumer(queue));
        Thread thread2 = new Thread(new MessageConsumer(queue));
        Thread thread3 = new Thread(new MessageConsumer(queue));

        Thread suplier = new Thread(new MessageSuplier(queue));

//        thread1.setDaemon(true);
//        thread2.setDaemon(true);
//        thread3.setDaemon(true);

        thread1.start();
        thread2.start();
        thread3.start();

        suplier.start();
    }
}
