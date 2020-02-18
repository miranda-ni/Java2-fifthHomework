import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;



public class Uploader extends Thread {

    private CountDownLatch cdl;
    private int speed = 500/20;



    public Uploader(CountDownLatch cdl) {
        this.cdl = cdl;
    }
    public synchronized void run(){
        try {
            for (int i = 1; i <=10 ; i++) {
                System.out.println(" File is loading " + i*10 + "%");
                sleep(100);



                cdl.countDown();



            }




        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}














