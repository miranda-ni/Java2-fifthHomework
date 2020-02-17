import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloader extends Thread {
    int downloadspeed =500/100;
    int id;
    Semaphore sem;
    CountDownLatch cdl;

    public Downloader(int id, Semaphore sem, CountDownLatch cdl) {
        this.id = id;
        this.sem = sem;
        this.cdl = cdl;
    }

    public synchronized void run(){
        try{
            sem.acquire();
         System.out.println(id + "start downloading");
         sleep(downloadspeed*1000);

            System.out.println(id + "finish downloading");
            sleep(downloadspeed*1000);
            cdl.countDown();





     } catch (Exception e) {
            e.printStackTrace();
        }
     }
}
