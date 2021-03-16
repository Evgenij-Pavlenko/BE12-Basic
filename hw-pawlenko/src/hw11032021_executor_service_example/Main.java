package hw11032021_executor_service_example;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        for (String url : listUrl) {
            executor.submit(new ImageDownload(url, directory));

        }
        if (!executor.isShutdown()){
            executor.shutdown();
        }
    }
}
