package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertInterval_57 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
        System.out.println(Arrays.deepToString(insertSimple(intervals, newInterval)));
    }

    public static int[][] insertSimple(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        for (; i < n && intervals[i][1] < newInterval[0]; i++) {
            result.add(intervals[i]);
        }

        for (; i < n && intervals[i][0] <= newInterval[1]; i++) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        }
        result.add(newInterval);


        for (; i < n; i++) {
            result.add(intervals[i]);
        }

        return result.toArray(new int[result.size()][]);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> outputList = new ArrayList<>();

        outputList.add(new int[]{newInterval[0], newInterval[1]});

        for (int i = 0; i < intervals.length; i++) {
            int[] prevInterval = outputList.get(outputList.size() - 1);
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart <= prevInterval[1]) {
                if (currStart <= prevInterval[0] && currEnd < prevInterval[0]) {
                    outputList.add(new int[]{currStart, currEnd});
                    Collections.sort(outputList, (o1, o2) -> o1[0]-o2[0]);
                } else {
                    outputList.remove(prevInterval);
                    int start = Math.min(currStart, prevInterval[0]);
                    int end = Math.max(intervals[i][1], prevInterval[1]);
                    outputList.add(new int[]{start, end});
                }
            } else outputList.add(new int[]{intervals[i][0], intervals[i][1]});

        }
     return outputList.toArray(new int[outputList.size()][]);
    }
}
