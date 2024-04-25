package threads;

public class Main {
    private static int latch = 0;
    public static void main(String[] args) {

        String[] imageUrls = {
                // Image URLs
        };

        String[] fileNames = {
                // File names
        };

        for (int i = 0; i < imageUrls.length; i++) {
            ImageDownloader downloader = new ImageDownloader(imageUrls[i], fileNames[i]);
            downloader.startDownload();
        }
        System.out.println(fileNames + " downloaded successfully!");
        latch--;
        while (latch > 0) {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Latch Wait" + latch);

        }
    }
}

