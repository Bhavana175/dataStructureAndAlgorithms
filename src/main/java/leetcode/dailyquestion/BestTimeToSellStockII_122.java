package leetcode.dailyquestion;

public class BestTimeToSellStockII_122 {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int [] prices){

        int sumProfit = 0;
        int n = prices.length;
        int buy = prices[0];
        for (int i = 1; i < n; i++) {
            if(buy>prices[i]){
                buy = prices[i];
            }else{
                int profit = prices[i]-buy;
                buy = prices[i];
                sumProfit +=profit;
            }
        }
        return sumProfit;
    }
}
