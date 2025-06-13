package leetcode.dailyquestion;

public class StockProfit {

    public static void main(String[] args) {

       // int days = 10;
        int [] prices = {16 ,1 ,9 ,2 ,11 ,1 ,9 ,2};
        System.out.println(getMaxProfit(8, prices));
    }

    public static int getMaxProfit(int days, int [] prices){

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i <days ; i++) {
            minPrice = Math.min(minPrice, prices[i]); // min price so far
            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
        }

        return maxProfit;
    }

}
