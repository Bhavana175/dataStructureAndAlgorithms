package leetcode.dailyquestion.dp;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci();
        System.out.println(fb.f(4));
        System.out.println(fb.memo(4));
        System.out.println(fb.functionDp(4));

    }

    public int f(int n){
        if(n<=1){
            return n;
        }
        return  f(n-1)+f(n-2);
    }

    //T= O(n) S = O(n) rec stack+ O(n) array
    public int memo(int n){
        int [] dp = new int [n+1];
        for (int i = 0; i < n+1; i++) {
            dp[i]=-1;
        }
        dp[0]=0;
        dp[1]=1;
       return memoization(n, dp);
    }

    private int memoization(int n, int[] dp) {
        if(dp[n]!=-1)return dp[n];
        return memoization(n-1, dp)+memoization(n-2,dp);
    }
    //T = O(n) S = O(n)
    public int functionDp(int n){
        int [] dp = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            dp[i]=-1;
        }
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}