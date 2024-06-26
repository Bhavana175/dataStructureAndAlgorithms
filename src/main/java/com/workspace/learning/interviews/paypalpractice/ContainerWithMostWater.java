package com.workspace.learning.interviews.paypalpractice;

public class ContainerWithMostWater {

    //https://leetcode.com/problems/container-with-most-water/description/
    /*
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array
     [1,8,6,2,5,4,8,3,7].
     [1,8,8,8,8,8,8,8,8] left max
     [8 8 8 8 8 8,8,7,7]

     In this case, the max area of water (blue section) the container can contain is 49.
     */
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int output = maxArea(height);
        System.out.println("output : " + output);
    }

    public static int maxArea(int[] height) {

        if (height.length < 1) {
            return 0;
        }
        // height max from right and max from left and width = index1-index2

        int l = 0, r = height.length - 1;
        int area = 0, maxArea = 0;

        while (l < r) {

            if (height[l] < height[r]) {
                area = height[l] * (r - l);
                maxArea = Math.max(maxArea, area);
                l++;
            } else {
                area = height[r] * (r - l);
                maxArea = Math.max(maxArea, area);
                r--;
            }

        }

        return maxArea;

    }

}
