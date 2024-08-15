package mylearning.com.multithreding;

public class MyThread extends Thread {

    private int count;

    public MyThread(int count) {
        this.count = count;
    }

   public void run() {

        for (int i = 1; i <= 10; i++) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(count);
            count++;
        }

    }
}
