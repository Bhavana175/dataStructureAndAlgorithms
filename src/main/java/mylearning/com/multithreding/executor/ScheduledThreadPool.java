package mylearning.com.multithreding.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        for(int i=0; i<10; i++){
            service.schedule(new ScheduledThreadPoolTask(), 10, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(new ScheduledThreadPoolTask(), 10,10, TimeUnit.SECONDS);
            service.scheduleWithFixedDelay(new ScheduledThreadPoolTask(), 10,10, TimeUnit.SECONDS);
        }
    }

}
class ScheduledThreadPoolTask implements Runnable
{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
