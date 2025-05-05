package leetcode.dailyquestion;

public class KnapsackWithCritical {

    public static int maxKnapsackValue(int[] weights, int[] values, int[] critical, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            int wt = weights[i - 1];
            int val = values[i - 1];
            int isCritical = critical[i - 1];

            for (int w = 0; w <= capacity; w++) {
                if (wt <= w) {
                    if (isCritical == 1) {
                        if (wt + val <= capacity) {
                            dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt] + val);
                        } else {
                            dp[i][w] = dp[i - 1][w];
                        }
                    } else {
                        dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt] + val);
                    }
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4};
        int[] values = {3, 4, 5};
        int[] critical = {0, 1, 0};
        int capacity = 6;

        int result = maxKnapsackValue(weights, values, critical, capacity);
        System.out.println("Maximum Value: " + result);
    }
}
