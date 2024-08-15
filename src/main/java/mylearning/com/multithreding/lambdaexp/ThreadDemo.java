package mylearning.com.multithreding.lambdaexp;

public class ThreadDemo {

    public static void main(String[] args) {

        // Lambda exp Runnable
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }, "Thread_hi");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }, "Thread_hello");

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();

        System.out.println("t1.isAlive()  :" + t1.isAlive());
        //priority
        System.out.println("t1 priority " + t1.getPriority());
        t1.setPriority(1);
        t2.setPriority(Thread.MAX_PRIORITY);
        System.out.println("t1 priority " + t1.getPriority());
        System.out.println("t2 priority " + t2.getPriority());

        try {
            t1.join();// wait for t1 to join
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //After join thread is not alive
        System.out.println("t1.isAlive()  :" + t1.isAlive());
        System.out.println(t1.getName());
        System.out.println(t2.getName());

    }

}
