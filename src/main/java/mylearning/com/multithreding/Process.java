package mylearning.com.multithreding;

public class Process {



    public void print(){

        System.out.println("Using main thread sleep for 500 mili sec ");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread resumed ");
    }

}
