package leetcode.dailyquestion.practice.amazon;

public class MaximumSubArray_53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
    // 1ms
    public static int maxSubArray_simple(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum =0;

        for (int num : nums){

            currSum +=num;
            maxSum = Math.max(currSum, maxSum);
            if(currSum<0){
                currSum =0;
            }

        }
        return maxSum;
    }



    // 11 ms time
    public static int maxSubArray(int[] nums) {
        return rec(nums, nums.length, Integer.MIN_VALUE, 0);
    }

    private static int rec(int[] nums, int n, int maxSum, int currSum) {

        if (n == 0) {
            return maxSum;
        }

        currSum = Math.max(nums[n-1], nums[n-1]+currSum);
        maxSum = Math.max(maxSum, currSum);

        return rec(nums, n-1, maxSum, currSum);
    }
}
