package leetcode.dailyquestion;


import java.util.Arrays;
import java.util.Stack;

public class NumberOfVisiblePeopleInQueue_1944 {
    public static void main(String[] args) {
        int[] heights = {10, 6, 8, 5, 11, 9};
        System.out.println(Arrays.toString(canSeePersonsCount(heights)));
    }

    public static int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int visibleCount = 0;

            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                visibleCount++;
            }
            if(!stack.isEmpty()) visibleCount++;

            output[i] = visibleCount;
            stack.push(heights[i]);
        }

        return output;
    }
}
