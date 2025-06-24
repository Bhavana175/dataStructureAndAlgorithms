package leetcode.dailyquestion;

import java.util.Arrays;

public class MaxRunningTimeNComputers2141 {
    public static void main(String[] args) {
        System.out.println(maxRunTime(3, new int []{10,10,3,5}));

    }
    public static long maxRunTime(int n, int[] batteries) {

        long sum = 0;
        long minTime = 0;
        Arrays.sort(batteries);
        for(int battery: batteries){
            sum += battery;
            minTime = Math.min(minTime, battery);
        }
        long time = minTime;
        long maxTime = sum/n;

        while (minTime <= maxTime){
            long mid = (minTime + maxTime)/2;
            if(possibleToRun(batteries, n, mid)){
                time = mid;
                minTime = mid+1;
            }else maxTime = mid -1;
        }
        return time;
    }

    private static boolean possibleToRun(int[] batteries, int n, long time) {
        long total = 0;
        for (int battery : batteries) {
            total += Math.min(battery, time);
        }
        return total >= n * time;
    }
}
