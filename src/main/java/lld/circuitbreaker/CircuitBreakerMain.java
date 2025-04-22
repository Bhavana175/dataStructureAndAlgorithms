package lld.circuitbreaker;

import java.time.Duration;

public class CircuitBreakerMain {

    //Design a circuit breaker

    // circuit 3 state : Open Close and Half-Open
    // Whenever rate of error failureCount > Threshold , limit ==> Open the circuit
    // if Open => Curr_time > Last_Failure_time+timeout  ==> we check by Half open
    // if succeeded reset the circuit ==> state Close and failure_Count =0;

    public static void main(String[] args) throws Exception {

        CircuitBreaker circuitBreaker = new CircuitBreaker(3, Duration.ofSeconds(5));

        for (int i = 0; i < 50; i++) {
            try {
               String result = circuitBreaker.execute(() -> {
                    if(Math.random()>0.5){
                        throw new RuntimeException("Service failure");
                    }
                    return "Service response 200 OK";
                });
                System.out.println(" "+result);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            //some delay b/w req
            Thread.sleep(10);
        }

    }


}
