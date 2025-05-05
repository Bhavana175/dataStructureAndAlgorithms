package leetcode.dailyquestion.dp;

public class Solution {
    public static void main(String[] args) {
        int[] weights = {2, 3, 4};
        int[] values = {3, 4, 5};
        int[] critical = {0, 1, 0};
        int capacity = 5;

        int result = maxKnapsackValueRec(weights, values, critical, capacity);
        int result1 = maxKnapsackValueTopDown(weights, values, critical, capacity);
        System.out.println("Maximum Value: " + result);
        System.out.println("Maximum Value: " + result1);
    }

    private static int maxKnapsackValueTopDown(int[] weights, int[] values, int[] critical, int capacity) {

        int n = weights.length;
        int W = capacity;
        int [][] dp = new int[n+1][W+1];

        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j < W+1; j++) {
                if(i==0 || j ==0){
                    dp[i][j]=0;
                }else {
                    dp[i][j] = -1;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1 ; j++) {
                int effectiveWeight = critical[i-1]==1?weights[i-1]+values[i-1]:weights[i-1];
                if(effectiveWeight<= j){//less thn the W
                    dp[i][j] = Math.max(effectiveWeight + dp[i-1][j-effectiveWeight], dp[i-1][j]);
                }else {
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    private static int maxKnapsackValueRec(int[] weights, int[] values, int[] critical, int capacity) {

        //recursion
        int n = weights.length;
        int W = capacity;

        return maxWeights(n, weights, values, critical, W);

    }

    private static int maxWeights(int n, int[] weights, int[] values, int[] critical, int W) {

        if (W == 0 || n == 0) {
            return 0;
        }
        int effectiveWeight = critical[n - 1] == 1 ? weights[n - 1] + values[n - 1] : weights[n - 1];

        if (effectiveWeight <= W) {
            return Math.max(effectiveWeight + maxWeights(n - 1, weights, values, critical, W - effectiveWeight),
                    maxWeights(n - 1, weights, values, critical, W));
        } else return  maxWeights(n - 1, weights, values, critical, W);
    }


}
