package com.workspace.learning.interviews.paypalpractice;

public class JumpGameII {

    //https://leetcode.com/problems/jump-game-ii/description/
/*
        Input: nums = [2,3,1,1,4]
        Output: 2
        Explanation: The minimum number of jumps to reach the
        last index is 2. Jump 1 step from index 0 to 1,
        then 3 steps to the last index.
 */
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        //  int output = jump(nums);
        //  System.out.println("output : " + output);

        int[] nums1 = {1, 2, 1, 1, 1};
        int output1 = jump(nums1);
        System.out.println("output : " + output1);

    }

    public static int jump(int[] nums) {
        int minJump = 0;
        int maxJump = 0;
        int current = 0;
        for (int i = 0; i < nums.length-1; i++) {

            maxJump = Math.max(maxJump, i + nums[i]);

            if (i == current) {
                current = maxJump;
                minJump++;
            }

        }
        return minJump;
    }
}
