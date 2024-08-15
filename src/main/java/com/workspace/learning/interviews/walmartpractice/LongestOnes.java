package com.workspace.learning.interviews.walmartpractice;

public class LongestOnes {

    //https://leetcode.com/problems/max-consecutive-ones-iii/description/
    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k));

    }

    public static int longestOnes(int[] nums, int k) {
        int count = k;
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                maxLen = Math.max(maxLen, i - start + 1);
            } else if (nums[i] == 0 && count > 0) {
                count--;
                maxLen = Math.max(maxLen, i - start + 1);
            } else {
                while (count == 0) {
                    if (nums[start] == 0) {
                        count++;
                    }
                    start++;
                }
                count--; // For the current zero we are including in the window
            }

        }

        return maxLen;

    }

}
