import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int Mb = 25;
    public static final int dl = 10;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(Mb);
        CountDownLatch cdl1 = new CountDownLatch(3);
        CountDownLatch cdl2 = new CountDownLatch(dl);

        Uploader uploader = new Uploader(cdl1);
        uploader.start();
        try {
            cdl1.await();
            System.out.println("File downloaded");
            System.out.println("_________________");

            for (int i = 1; i <=dl ; i++) {
                Downloader downloader =new Downloader(i,semaphore,cdl2);
                downloader.start();

            }
            cdl2.await();
            System.out.println("File is deleted");






        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
