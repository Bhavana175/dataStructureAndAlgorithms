package leetcode.dailyquestion.dp;

public class HouseRobber198_1 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        // Output: 4
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {

        int n = nums.length;
        int [] t = new int[n];

        t[0] = nums[0];
        t[1] = nums[1];

        for (int i = 2; i <n ; i++) {
           t[i] = Math.max(t[i-2]+nums[i], t[i-1]);
        }

        return t[n-1];
    }
}
