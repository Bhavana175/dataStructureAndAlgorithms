package leetcode.dailyquestion;

public class MaxSumCircularSubArray918 {
    public static void main(String[] args) {
        int [] nums = {5, -3, 5};
        //Output: 3
        System.out.println(maxSubarraySumCircular(nums));
    }
    public static int maxSubarraySumCircular(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int currSum =0;

        for(int i=0; i<nums.length-1; i++){
            currSum = Math.max(currSum+nums[i] , nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        maxSum = Math.max(maxSum, maxSum+nums[0]+nums[nums.length-1]);
        return maxSum;
    }
}
