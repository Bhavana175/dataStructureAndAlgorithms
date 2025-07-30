package leetcode.dailyquestion.practice.amazon;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l <= r) {
            int len = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, len * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else r--;
        }
        return maxArea;
    }

}
