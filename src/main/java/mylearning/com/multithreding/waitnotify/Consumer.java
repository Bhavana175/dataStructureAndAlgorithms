package mylearning.com.multithreding.waitnotify;

public class Consumer implements  Runnable{

    Sample s;

    public Consumer(Sample s) {
        this.s = s;
        Thread t2 = new Thread(this, "Consumer-Thread");
        t2.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                s.getNum();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
