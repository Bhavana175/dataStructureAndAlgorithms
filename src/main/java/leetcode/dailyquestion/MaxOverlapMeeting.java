package leetcode.dailyquestion;

import java.util.Arrays;

public class MaxOverlapMeeting {
    public static void main(String[] args) {
        int[] start = {1, 6, 4, 3, 1};
        int[] end = {2, 7, 5, 8, 2};

        System.out.println("Maximum team size: " + maxTeamSize(5,start, end));
    }
    public static int maxTeamSize(int n, int [] start, int [] end ){

        //O(nlog(n))
        int [] sortedStartTime = Arrays.copyOf(start,n);
        int [] sortedEndTime = Arrays.copyOf(end,n);

        Arrays.sort(sortedStartTime);
        Arrays.sort(sortedEndTime);

        int maxTeamSize =0;
        int currTeamSize =0;

        //O(n*n) nested loop inside
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int startCount =0;
                int endCount =0;

                // how many meeting started before end time
                for (int started : sortedStartTime){
                    if(started<end[i]){
                        startCount++;
                    }
                }
                // how many meeting ended before start time
                for (int ended : sortedEndTime){
                    if(ended < start[i]){
                        endCount++;
                    }

                }

                currTeamSize = startCount - endCount;
                maxTeamSize = Math.max(maxTeamSize, currTeamSize);
            }
        }

        return maxTeamSize;
    }
}
