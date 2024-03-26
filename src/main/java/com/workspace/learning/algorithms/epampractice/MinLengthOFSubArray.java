package com.workspace.learning.algorithms.epampractice;

public class MinLengthOFSubArray {

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

        MinLengthOFSubArray obj = new MinLengthOFSubArray();
        int [] nums = {2,3,1,2,4,3};

        int k= 2;
        //
        int output = obj.getMinLengthSubarray(nums, k);
        System.out.println(output);

    }

    private int getMinLengthSubarray(int[] nums, int k) {
        int minLen= Integer.MAX_VALUE;
        int sum=0;

        for(int i=0, start =0; i<nums.length; i++){

            sum+=nums[i];
            while (sum>=k){
                minLen = Math.min(minLen, i-start+1 );
                sum=sum-nums[start];
                start++;
            }

        }
        return minLen;
    }

}
