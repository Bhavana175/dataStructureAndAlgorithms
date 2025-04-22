package lld.circuitbreaker;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Supplier;

import static lld.circuitbreaker.State.CLOSED;
import static lld.circuitbreaker.State.HALF_OPEN;

public class CircuitBreaker {

    private State state;
    private final int threshold;
    private final Duration timeout;
    private int failureCount;
    private LocalDateTime lastFailureTime;

    public CircuitBreaker(int threshold, Duration timeout) {
        this.threshold = threshold;
        this.timeout = timeout;
        this.state = CLOSED;
        this.failureCount = 0;
        this.lastFailureTime = LocalDateTime.now();
    }

    public State getStatus() {
        return state;
    }

    public void open() {
        state = State.OPEN;
        lastFailureTime = LocalDateTime.now();

    }

    public void reset() {
        state = State.CLOSED;
        failureCount = 0;
    }

    public synchronized <T> T execute(Supplier<T> supplier) throws Exception {

        switch (state) {
            case OPEN:
                if (LocalDateTime.now().isAfter(lastFailureTime.plus(timeout))) {
                    state = HALF_OPEN;
                } else {
                    throw new Exception("Circuit Breaker is OPEN ");
                }
            case HALF_OPEN:
                try {
                    T result = supplier.get();
                    reset();
                    return result;
                } catch (Exception e) {
                    open();
                    throw new Exception("CB Failed at HALF_OPEN");
                }
            case CLOSED:
                try {
                    T result = supplier.get();
                    reset();
                    return result;
                } catch (Exception e) {
                    failureCount++;
                    if (failureCount >= threshold) {
                        open();
                        throw new Exception("Circuit is not open with failureCount " + failureCount);
                    }
                    throw new Exception("Failed , failureCount " + failureCount);
                }


        }
        return null; // should not reach here

    }


}
