package mylearning.com.multithreding;

public class Client {

    public static void main(String[] args) {

        //main thread
        Process process = new Process();
        process.print();
        // can create a thread class using extending to Thread class or implementing Runnable interface
        Runnable myThread = new MyThread(50); //extend
        Runnable myThread2 = new MyThread2(20); // implement

        Thread t1= new Thread(myThread,"first thread");
        Thread t2= new Thread(myThread2,"first thread");


        //create anonymous class using runnable interface as it's a functional interface
        // need to override run method

        Runnable anonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("inside anonymous class ");
                System.out.println("anonymous Thread name : "+Thread.currentThread().getName());
            }
        };

        Thread t3 = new Thread(anonymous,"Thread 3");

        // As Runnable is functional interface we can use lambda expression

        Runnable lambdaExp =()->{
                System.out.println("inside lambdaExp class ");
                System.out.println("lambdaExp Thread name : "+Thread.currentThread().getName());};

        Thread t4 = new Thread(lambdaExp,"Thread 4");


        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread  ");
    }
}
