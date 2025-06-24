package leetcode.dailyquestion;

import java.util.Stack;

public class SumOfSubArrayMinimums907 {
    public static void main(String[] args) {
        int[] arr = {11, 81, 94, 43, 3};
        // Output: 444
        System.out.println(sumSubarrayMins(arr));
    }

    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int MOD = 1000000007;
        Stack<Integer> stackIndex = new Stack<>();
        int[] leftMinElement = new int[n];
        int[] rightMinElement = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stackIndex.isEmpty() && arr[stackIndex.peek()] > arr[i]) {
                stackIndex.pop();
            }
            leftMinElement[i] = stackIndex.isEmpty() ? -1 : stackIndex.peek();
            stackIndex.push(i);
        }

        stackIndex.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stackIndex.isEmpty() && arr[stackIndex.peek()] >= arr[i]) {
                stackIndex.pop();
            }
            rightMinElement[i] = stackIndex.isEmpty() ? n : stackIndex.peek();
            stackIndex.push(i);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - leftMinElement[i];
            long rightCount = rightMinElement[i] - i;
            result = (result + (arr[i] * leftCount % MOD) * rightCount % MOD) % MOD;
        }

        return (int) result;
    }
}
