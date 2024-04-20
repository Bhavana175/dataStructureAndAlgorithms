package com.workspace.learning.datastructure.stacks.problems;

import java.util.Stack;

public class TrapRainWater {

    //https://leetcode.com/problems/trapping-rain-water/description/?envType=daily-question&envId=2024-04-12
    //Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    // Output: 6

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        TrapRainWater obj = new TrapRainWater();
        int output = obj.trap(height);
        System.out.println("output : "+output);
    }

    private int trap(int[] height) {
        int water = 0;
        //using stack
        //{0,1,0,2,1,0,1,3,2,1,2,1}
        //store index  in stack, will be used for cal distance;
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                water += (distance * boundedHeight);
            }
            stack.push(i);
        }

        return water;
    }

}
