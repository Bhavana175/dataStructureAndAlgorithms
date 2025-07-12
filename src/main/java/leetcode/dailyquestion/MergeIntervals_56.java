package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {
    public static void main(String[] args) {
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)->o1[0]-o2[0]);
        List<int[]> outputList = new ArrayList<>();

        outputList.add(new int [] {intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int [] prevInterval = outputList.get(outputList.size()-1);
            if(start<=prevInterval[1]){
                outputList.remove(outputList.size()-1);
                int end = Math.max(prevInterval[1], intervals[i][1]);
                outputList.add(new int [] {prevInterval[0],end});
            }else {
                outputList.add(new int [] {intervals[i][0], intervals[i][1]});
            }
        }
        int [][] output = new int[outputList.size()][2];
        int i=0;
        for (int [] arr: outputList){
            output[i] = arr;
            i++;
        }

        return output;
    }

}
