import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static final int Mb = 25;
    public static final int dl = 10;

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3,true);
        CountDownLatch cdl1 = new CountDownLatch(Mb);
        CountDownLatch cdl2 = new CountDownLatch(dl);

        Thread thread = new Thread(new Uploader(cdl1));
        thread.start();
        thread.join();






            for (int i = 1; i <=dl ; i++) {
                Thread thread1 = new Thread(new Downloader(i,semaphore,cdl2));
                thread1.start();

            }
            cdl2.await();
        System.out.println("File is deleted");







    }
}
