import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Uploader extends Thread {

    CountDownLatch cdl;

    public Uploader(CountDownLatch cdl) {
        this.cdl = cdl;
    }
    public synchronized void run(){
        try {
            for (int i = 1; i <=10 ; i++) {
                System.out.println("File is loading" +i*10 + "%");
                sleep(1000);
                cdl.countDown();



            }




        } catch (Exception e) {
            e.printStackTrace();
        }



        }

        }







