package com.workspace.learning.algorithms.dailyquetions;
import java.util.Stack;
public class TrappingRainWater {

    //https://leetcode.com/problems/trapping-rain-water/description/?envType=daily-question&envId=2024-04-12
    //Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    // Output: 6

    public static void main(String[] args) {

        TrappingRainWater obj = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //int output = obj.trapArray(height);
        int output2 = obj.trapStack(height);
       // System.out.println(output);
        System.out.println(output2);
    }

    public int trap(int[] height) {

        int water = 0;
        int val = 0;
        //[0,1,0,2,1,0,1,3,2,1,2,1]
        for (int i = 2, start = 1; i < height.length; i++) {
            if (height[start] <= height[i]) {
                for (int j = start; j <= i; j++) {
                    val = height[start] - height[j];
                    if (val > 0) {
                        water++;
                    }
                }
                start=i;
            }
        }

        return water;
    }

    public int trapArray(int[] height) {
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        leftMax[0] = height[0];
        rightMax[rightMax.length-1] = height[rightMax.length-1];
        for(int i=1;i<height.length;i++){
            //          [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
            //leftMax = [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3] --->
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        for(int i=rightMax.length-2;i>=0;i--){
            //           [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
            //rightMax = [3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]  <-----
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        int ans = 0;
        for(int i=0;i<height.length;i++){

            ans += Math.min(leftMax[i],rightMax[i]) - height[i];
            // (min of left and right )  - actual height
        }
        return ans;
    }


    public int trapStack(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int trappedWater = 0;
        Stack<Integer> stack = new Stack<>();

        for (int current = 0; current < n; current++) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                System.out.println(top);
                if (stack.isEmpty()) {
                    break;
                }

                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                trappedWater += distance * boundedHeight;
            }
            stack.push(current);
        }

        return trappedWater;
    }



}
