package leetcode.dailyquestion.dp;

public class MaxSubArraySum53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // Output: 6
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int num : nums) {
            currSum = Math.max(currSum + num, num);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
