package leetcode.dailyquestion;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;

        while (l < r) {

            int minHeight = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, ((r - l) * minHeight));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }

        }
        return maxArea;
    }
}
