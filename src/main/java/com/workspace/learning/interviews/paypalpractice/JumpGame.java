package com.workspace.learning.interviews.paypalpractice;

public class JumpGame {
    //https://leetcode.com/problems/jump-game/description/

    /*
    Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3
no matter what. Its maximum jump length is 0, which
 makes it impossible to reach the last index.

     */
    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 0, 4};
        boolean output = canJump(nums);
        System.out.println("output : " + output);

        int[] nums1 = {2, 3, 1, 1, 4};
        boolean output1 = canJump(nums1);
        System.out.println("output : " + output1);

    }

    public static boolean canJump(int[] nums) {

        int maxDistance = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxDistance) return false;
            maxDistance = Math.max(maxDistance, i + nums[i]);
        }
        return true;
    }
}
