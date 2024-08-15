package mylearning.com.multithreding.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

    public static void main(String[] args) {

        //blocking queue
        ExecutorService service = Executors.newFixedThreadPool(2);

        for (int i=0; i<5; i++){

            service.execute(new Task());
        }

    }

}
class Task implements  Runnable{

    int count;
    @Override
    public void run() {

        System.out.println("fixed thread pool size "+Thread.currentThread().getName());

    }
}
