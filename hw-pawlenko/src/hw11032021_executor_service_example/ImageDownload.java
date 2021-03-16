package hw11032021_executor_service_example;


import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;

public class ImageDownload implements Runnable {

    Object mutex = new Object();

    String url;
    String directory;

    public ImageDownload(String url, String directory) {
        this.url = url;
        this.directory = directory;
    }

    @Override
    public void run() {

        try {
            int lastIndex = url.lastIndexOf('/');
            String fileOutputName = url.substring(lastIndex + 1);
            System.out.println(fileOutputName);
            FileOutputStream fout = new FileOutputStream(directory + fileOutputName);
            BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }

        } catch (Exception er) {
            er.printStackTrace();
        }
    }
}
