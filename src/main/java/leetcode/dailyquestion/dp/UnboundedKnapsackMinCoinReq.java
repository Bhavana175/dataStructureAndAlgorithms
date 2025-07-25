package leetcode.dailyquestion.dp;

public class UnboundedKnapsackMinCoinReq {
    public static void main(String[] args) {
        System.out.println(minCoinRequiredForAmount(new int [] {1,2,3}, 10));
    }
    public static int minCoinRequiredForAmount(int [] coins, int amount){
        int n = coins.length;

        int [][] t = new int[n+1][amount+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                if(j==0){
                    t[i][j] = 0;
                }
                if(i==0){
                    t[i][j] = Integer.MAX_VALUE-1;
                }
                if(i==1){
                    t[i][j] = j%coins[0]==0 ? j/coins[0]: Integer.MAX_VALUE-1;
                }
            }
        }

        for (int i = 2; i <n+1 ; i++) {
            for (int amtj = 1; amtj < amount+1; amtj++) {
                if(coins[i-1]<=amtj){
                    t[i][amtj] = Math.min(t[i][amtj-coins[i-1]]+1, t[i-1][amtj]);
                }else t[i][amtj] = t[i-1][amtj];
            }
        }
        return t[n][amount];
    }
}
