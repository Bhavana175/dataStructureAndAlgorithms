package leetcode.dailyquestion.dp;

public class UnboundedKnapsackCoinChange {
    public static void main(String[] args) {
        System.out.println(findMaxNumberOfWaysForGivenAmount(new int []{1,2,3}, 5));
    }
    public static int findMaxNumberOfWaysForGivenAmount(int [] coins, int amount){

        int n = coins.length;

        int [][] t = new int[n+1][amount+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <n+1 ; i++) {
            for (int amtj = 1; amtj < amount+1; amtj++) {
                if(coins[i-1]<=amtj){
                    t[i][amtj] = t[i][amtj-coins[i-1]] + t[i-1][amtj];
                }
                else t[i][amtj] = t[i-1][amtj];
            }
        }

        return t[n][amount];

    }
}
