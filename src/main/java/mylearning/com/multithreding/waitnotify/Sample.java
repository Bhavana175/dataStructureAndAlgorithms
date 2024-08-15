package mylearning.com.multithreding.waitnotify;

public class Sample {

    int num;

    boolean value;
    public synchronized void getNum() throws InterruptedException {
        while (!value)
        { //if value is not present wait to print after value is available
            System.out.println("Wait  : "+Thread.currentThread().getName());
            wait();
        }
        System.out.println("Get   : "+this.num);
        value=false;
        notify();
    }

    public synchronized void setNum(int number) throws InterruptedException {
        while (value){
            //if value is present wait do not set new value
           // System.out.println("Wait  : "+Thread.currentThread().getName());
            wait();
        }
        this.num = number;
        Thread.sleep(1000);
        System.out.println("Set   : "+number);
        value= true;
        notify();
    }
}
