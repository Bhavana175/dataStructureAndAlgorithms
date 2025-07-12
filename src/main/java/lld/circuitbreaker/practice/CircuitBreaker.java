package lld.circuitbreaker.practice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class CircuitBreaker {

    State state;
    int failureCount;
    int thresholdCount;
    Duration timeoutDuration;
    LocalDateTime lastFailedTime;

    public CircuitBreaker(int thresholdCount, Duration timeoutDuration) {
        this.state = State.CLOSED;
        this.failureCount = 0;
        this.thresholdCount = thresholdCount;
        this.timeoutDuration = timeoutDuration;
        this.lastFailedTime = LocalDateTime.now();
    }

    public void open() {
        this.state = State.OPEN;
        this.lastFailedTime = LocalDateTime.now();
    }

    public void reset() {
        this.state = State.CLOSED;
        this.failureCount = 0;
    }

    public <T> T excecute(Supplier<T> supplier) throws Exception {

        switch (state) {

            case OPEN -> {
                if (LocalDateTime.now().isAfter(lastFailedTime)) {
                    state = State.HALF_OPEN;
                }
            }
            case HALF_OPEN -> {
                try {
                    T result = supplier.get();
                    reset();
                    return result;
                } catch (Exception e) {
                    open();
                    throw new Exception("Circuit failed half open");
                }
            }
            case CLOSED -> {
                try {
                    T result = supplier.get();
                    reset();
                    return result;
                } catch (Exception e) {
                    failureCount++;
                    if (failureCount >= thresholdCount) {
                        open();
                        throw new Exception("Circuit is now open");
                    } else throw new Exception("failure count " + failureCount);
                }
            }
        }

        return null;
    }

}
