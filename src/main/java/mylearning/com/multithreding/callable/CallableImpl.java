package mylearning.com.multithreding.callable;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableImpl {

    public static void main(String[] args) {

      //main thread block nhi hoga   CompletableFuture.supplyAsync(()->)


        ExecutorService service = Executors.newFixedThreadPool(2);

        Future future = service.submit(new CallableTsk());
        try {
            System.out.println("future :"+future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
class CallableTsk implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception {

        Thread.sleep(100);
        return new Random().nextInt();
    }
}
