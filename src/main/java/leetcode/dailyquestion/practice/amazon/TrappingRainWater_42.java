package leetcode.dailyquestion.practice.amazon;

public class TrappingRainWater_42 {
    public static void main(String[] args) {

    }
    public int trap(int[] height) {
        int [] leftMaxForEachIndex = new int[height.length];
        int leftMax = 0;

        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftMaxForEachIndex[i] = leftMax;
        }
        int waterSum =0;
        int rightMax = Integer.MIN_VALUE;

        for (int i = height.length-1; i >=0 ; i--) {
            rightMax = Math.max(rightMax, height[i]);
            waterSum += Math.min(leftMaxForEachIndex[i], rightMax)-height[i];
        }

        return waterSum;
    }

}
