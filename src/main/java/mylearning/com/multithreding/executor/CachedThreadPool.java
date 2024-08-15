package mylearning.com.multithreding.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    public static void main(String[] args) {

        // create a new thread when no thread is available
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i=0; i<10; i++){
            service.execute(new CachedThreadPoolTask());
        }

    }

}
class CachedThreadPoolTask implements Runnable
{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        //task
    }
}
