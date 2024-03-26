package com.workspace.learning.algorithms.subarray;

public class SubArray {

    /**
     * Given an array of positive integers nums and a positive integer target,
     * return the minimal length of a subarray
     * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     * Example 1:
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     */

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target2 = 11;
        int[] nums2 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 4;
        int[] nums3 = {1, 4, 4};



        SubArray obj = new SubArray();
        System.out.println(obj.minSubArrayLen(target, nums));
        System.out.println(obj.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(" :" + obj.minSubArrayLen(target2, nums2));
        System.out.println(" :" + obj.minSubArrayLen(target3, nums3));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int start = 0, i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
                while (sum >= target) {
                    min = Math.min(min, i - start + 1);
                    sum = sum - nums[start];
                    start++;
                }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
