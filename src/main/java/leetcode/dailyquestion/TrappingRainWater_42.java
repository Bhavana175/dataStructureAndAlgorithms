package leetcode.dailyquestion;

public class TrappingRainWater_42 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {

        int leftMax = 0;
        int rightMax = 0;
        int[] leftMaxArr = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftMaxArr[i] = leftMax;
        }
        int sum = 0;
        for (int i = height.length - 1; i > 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            sum += (Math.min(rightMax, leftMaxArr[i])) - height[i];

        }
        return sum;
    }
}
