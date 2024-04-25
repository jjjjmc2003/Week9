package threads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ImageDownloader {
    private String imageUrl;
    private String fileName;

    public ImageDownloader(String imageUrl, String fileName) {
        this.imageUrl = imageUrl;
        this.fileName = fileName;
    }

    public void startDownload() {
        DownloadThread downloadThread = new DownloadThread();
        downloadThread.start();
    }

    private class DownloadThread extends Thread {
        @Override
        public void run() {
            try {
                URL url = new URL(imageUrl);
                InputStream inputStream = url.openStream();
                FileOutputStream outputStream = new FileOutputStream(fileName);

                byte[] buffer = new byte[2048];
                int length;

                while ((length = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, length);
                }

                outputStream.close();
                inputStream.close();

                System.out.println(fileName + " downloaded successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String[] imageUrls = {
                "https://cdn.wccftech.com/wp-content/uploads/2012/01/die-shot-300x266.jpg",
                "https://qph.cf2.quoracdn.net/main-qimg-80a802bfbafb3ce9619ab74681a84dcb-lq",
                "https://www.nvidia.com/content/dam/en-zz/Solutions/gtcs22/design-visualization/rtx/proviz-rtx-ampere-2c50-p@2x.jpg",

        };

        String[] fileNames = {
                "Description.jpg",
                "CPU.jpg",
                "GPU.jpg"
        };

        for (int i = 0; i < imageUrls.length; i++) {
            ImageDownloader downloader = new ImageDownloader(imageUrls[i], fileNames[i]);
            downloader.startDownload();
        }
    }
}