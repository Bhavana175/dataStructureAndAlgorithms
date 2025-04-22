package lld.ratelimiter;

import java.time.Duration;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowRateLimiter {

    private final int maxReq;
    private final Duration timePeriod;
    private Queue<Long> requestTimestampQueue ;

    public SlidingWindowRateLimiter( int maxReq, Duration timePeriod) {
        this.timePeriod = timePeriod;
        this.maxReq = maxReq;
        this.requestTimestampQueue = new LinkedList<>();
    }

    public boolean allowRequest(){

        long now = System.currentTimeMillis();
        while (!requestTimestampQueue.isEmpty() && now- timePeriod.toMillis()> requestTimestampQueue.peek()){
            requestTimestampQueue.poll();
        }

        if(requestTimestampQueue.size()>=maxReq){
            return false;
        }else {
            requestTimestampQueue.add(now);
            return true;
        }
    }
}
