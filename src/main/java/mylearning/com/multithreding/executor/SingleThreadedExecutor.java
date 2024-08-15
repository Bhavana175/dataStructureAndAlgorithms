package mylearning.com.multithreding.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadedExecutor {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i=0; i<10; i++){
        service.execute(new SingleTask());}
    }

}
class SingleTask implements  Runnable
{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
