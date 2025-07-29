package leetcode.dailyquestion.practice.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> result = new ArrayList<>();

        result.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int[] prevMeeting = result.get(result.size() - 1);

            if(currStart< prevMeeting[1]){
                result.remove(result.size()-1);
                result.add(new int [] {Math.min(currStart, prevMeeting[0]), Math.max(currEnd,prevMeeting[1])});
            }else{
              result.add(new int [] {currStart, currEnd});
            }
        }
        int[][] output = new int[result.size()][2];
        int i = 0;
        for (int[] arr : result) {
            output[i] = arr;
            i++;
        }
        return output;
    }
}
