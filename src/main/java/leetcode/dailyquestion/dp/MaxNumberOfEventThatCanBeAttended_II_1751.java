package leetcode.dailyquestion.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNumberOfEventThatCanBeAttended_II_1751 {
    public static void main(String[] args) {
        int[][] events = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
        int k = 2;
        System.out.println(maxValue(events, k));
    }

    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        ArrayList<int[]> list = new ArrayList<>();
        int n = events.length;
        int[][] t = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(t[i], -1);
        }
        return recurtion(list, events, k, 0, 0);

    }

    private static int recurtion(ArrayList<int[]> list, int[][] events, int k, int index, int sum) {

        if (index > events.length - 1 || k == 0) {
            return sum;
        }
        int[] curr = events[index];
        int select = 0;
        int notSelect = 0;

        if (!list.isEmpty() && curr[0] <= list.get(list.size() - 1)[1]) {
            notSelect = recurtion(new ArrayList<>(list), events, k, index + 1, sum);
            sum = notSelect;
        } else {
            notSelect = recurtion(new ArrayList<>(list), events, k, index + 1, sum);
            list.add(curr);
            select = recurtion(new ArrayList<>(list), events, k - 1, index + 1, sum + curr[2]);
            sum = Math.max(select, notSelect);
        }

        return sum;
    }
}
