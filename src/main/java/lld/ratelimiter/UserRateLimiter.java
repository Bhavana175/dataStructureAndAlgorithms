package lld.ratelimiter;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;

public class UserRateLimiter {

    private final int userMaxReq;
    private final int userWindowSizeInMillis;
    private final ConcurrentHashMap<String , SlidingWindowRateLimiter> userRatelimiter;

    public UserRateLimiter(int userMaxReq, int userWindowSizeInMillis) {
        this.userMaxReq = userMaxReq;
        this.userWindowSizeInMillis = userWindowSizeInMillis;
        this.userRatelimiter = new ConcurrentHashMap<>();
    }

    public boolean allowRequest(String userId){

        SlidingWindowRateLimiter rateLimiter = userRatelimiter.computeIfAbsent(userId,
                k -> new SlidingWindowRateLimiter(userMaxReq, Duration.ofMillis(userWindowSizeInMillis)));

        return rateLimiter.allowRequest();
    }


    public static void main(String[] args) throws InterruptedException {
        UserRateLimiter userRateLimiter = new UserRateLimiter(5,1000);
        String userId = "user123";
        for (int i = 0; i < 20; i++) {

            if(userRateLimiter.allowRequest(userId)){
                System.out.println(userId +" is allowed");
            }else {
                System.out.println(userId +" not allowed");
            }

            Thread.sleep(1000);
        }

    }
}
