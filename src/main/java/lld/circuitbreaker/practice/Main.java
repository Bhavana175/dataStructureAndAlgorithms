package lld.circuitbreaker.practice;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws Exception {

        CircuitBreaker cb = new CircuitBreaker(4, Duration.ofSeconds(5));

        for (int i = 0; i < 30; i++) {
            try {
                String result = cb.excecute(() -> {
                    if (Math.random() > 0.5) {
                        throw new RuntimeException("Service failure");
                    }
                    return "Service response 200 OK";
                });
                System.out.println( "  "+result);
            } catch (Exception e) {
                System.out.println(e);
            }
        }


    }
}
