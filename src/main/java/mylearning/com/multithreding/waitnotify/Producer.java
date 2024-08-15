package mylearning.com.multithreding.waitnotify;

public class Producer implements Runnable {

    Sample s;

    public Producer(Sample s) {
        this.s = s;
        Thread t1 = new Thread(this, "Producer-Thread");
        t1.start();
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (i <30) {
                s.setNum(i++);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
