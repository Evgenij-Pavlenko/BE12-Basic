package hw11032021_executor_service_example;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Main {
    static String file = "src/image-url.txt";
    static String directory = "outImages/";

    public static void main(String[] args) {
        List<String> listUrl = new ArrayList<>();

        try {
            listUrl = Files.lines(Paths.get(file).toAbsolutePath()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future<Integer> future = null;
        for (String url : listUrl) {
            future = executor.submit(new ImageDownload(url, directory));

        }

        while (!future.isDone()){

        }
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (!executor.isShutdown()){
            executor.shutdown();
        }
    }
}
