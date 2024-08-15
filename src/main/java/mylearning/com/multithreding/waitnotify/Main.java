package mylearning.com.multithreding.waitnotify;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        Sample s = new Sample();

       new Producer(s);
       new Consumer(s);

        //Map
       // ConcurrentHashMap

    }

}
