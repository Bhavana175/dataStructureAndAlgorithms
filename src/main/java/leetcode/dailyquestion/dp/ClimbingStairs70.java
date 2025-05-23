package leetcode.dailyquestion.dp;

public class ClimbingStairs70 {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs70().climbStairs(4));
    }
    public int climbStairs(int n) {

        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1]=1;
        //dp[2] = 2;

        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
