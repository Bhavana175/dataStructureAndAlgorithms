package com.workspace.learning.interviews.paypalpractice;

public class RainWaterTrapping {
    //https://leetcode.com/problems/trapping-rain-water/description/

    /*
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section)
     is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
     In this case, 6 units of rain water (blue section)
     are being trapped.
     */
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //
        int output = trap(height);
        System.out.println("output :" + output);
    }

    public static int trap(int[] height) {

        int leftMax = 0, rightMax = 0, len = height.length - 1;
        int[] arr = new int[height.length];
        int sum = 0;

        for (int i = 0; i < height.length; i++) {

            leftMax = Math.max(leftMax, height[i]);
            arr[i] = leftMax;

        }

        for (int i = len; i > 0; i--) {

            rightMax = Math.max(rightMax, height[i]);
            sum += Math.min(rightMax, arr[i]) - height[i];

        }

        return sum;

    }
}
