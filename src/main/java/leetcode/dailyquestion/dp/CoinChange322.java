package leetcode.dailyquestion.dp;

public class CoinChange322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 13;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] t = new int[n + 1][amount + 1];

        //base condition

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j == 0) {
                    t[i][j] = 0;
                }
                if (i == 0) {
                    t[i][j] = Integer.MAX_VALUE - 1;
                }
                if (i == 1 && j>0) {
                    t[i][j] = j % coins[0] == 0 ? j / coins[0] : Integer.MAX_VALUE - 1;
                }
            }
        }

        for (int i = 2; i < n + 1; i++) {
            for (int amtj = 1; amtj < amount + 1; amtj++) {
                if (coins[i - 1] <= amtj) {
                    t[i][amtj] = Math.min(1 + t[i][amtj - coins[i - 1]], t[i - 1][amtj]);
                } else t[i][amtj] = t[i - 1][amtj];
            }
        }

        return t[n][amount] == Integer.MAX_VALUE - 1 ? -1 : t[n][amount];
    }
}
