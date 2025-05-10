package leetcode.dailyquestion.dp;

public class HouseRobber198 {

    public static void main(String[] args) {
       int [] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int[nums.length];

        dp[0] = nums[0];
        for (int i = 1; i <n ; i++) {
            int rob = nums[i];
            if(i>1) rob+= dp[i-2];
            int notRob = dp[i-1];
            dp[i] = Math.max(rob, notRob);
        }
        return dp[n-1];
    }
}
