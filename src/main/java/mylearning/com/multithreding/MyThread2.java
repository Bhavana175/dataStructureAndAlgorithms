package mylearning.com.multithreding;

public class MyThread2 implements Runnable{

    public MyThread2(int value) {
        this.value = value;
    }

    int value;
    @Override
    public void run() {
        for(int i=1; i<=10; i++){

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Value : "+value);
            value++;
        }
    }
}
