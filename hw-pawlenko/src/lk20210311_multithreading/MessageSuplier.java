package lk20210311_multithreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MessageSuplier implements Runnable{
    private  SingleItemQueue queue;

    public MessageSuplier(SingleItemQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            while ((line = reader.readLine())!=null && !line.equals("exit")){
                queue.addFirst(line);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
