package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.List;

public class RescheduleMeetingMaxFreeTime_3439 {
    public static void main(String[] args) {
        int eventTime = 5, k = 1;
        int [] startTime = {1,3}, endTime = {2,5};

        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));
    }
    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

        List<Integer>  gaps = new ArrayList<>();
        int n = startTime.length;
        //add gap to list
        gaps.add(startTime[0]);
        for (int i = 1; i <n ; i++) {
            gaps.add(startTime[i]-endTime[i-1]);
        }
        gaps.add(eventTime- endTime[n-1]);

        int currentSum =0, res =0;

        for (int i = 0; i < k+1; i++) {
            currentSum +=gaps.get(i);
        }
        res = currentSum;
        for (int i = 1; i+k <gaps.size() ; i++) {
            currentSum -=gaps.get(i-1);
            currentSum +=gaps.get(i+k);
            res = Math.max(res, currentSum);
        }

        return res;
    }
}
