package mylearning.com.multithreding.lambdaexp;

public class SyncDemo {

    public static void main(String[] args) throws InterruptedException {

        Counter c= new Counter();

        Thread t1 = new Thread(()->{
            for (int i=0; i<1000; i++){
                c.increment();
            }

        });

        Thread t2 = new Thread(()->{
            for (int i=0; i<1000; i++){
                c.increment();
            }

        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Count : "+c.count);
    }





}
class Counter{
    int count ;

    // both thread accessing the method same time
    // make it thread safe
    // use synchronized , only one thread can use at a time
    public synchronized void  increment(){
        count++;
    }

}
