package leetcode.dailyquestion.dp;

public class UnboundedDpRodCutting {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/dsa/cutting-a-rod-dp-13/

       int  price[] =  {1, 5, 8, 9, 10, 17, 17, 20};
       int  price1 [] =  {3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(calculateMaxProfit(price1, 8));
      //  Output: 22
    }

    public static int calculateMaxProfit(int [] prices, int rodLength){

        int [] rodCutting = new int[rodLength];
        for (int i = 0; i <rodLength ; i++) {
            rodCutting[i] = i+1;
        }

        int [][] t = new int[rodLength+1][rodLength+1];

        for (int i = 1; i < rodLength+1; i++) {
            for (int cutSize = 1; cutSize < rodLength+1; cutSize++) {
                if(rodCutting[i-1]<= cutSize){
                                            // choose t[i], don,t to reduce t[i-1]
                    t[i][cutSize] = Math.max(prices[i-1]+t[i][cutSize-rodCutting[i-1]] , t[i-1][cutSize]);
                }else t[i][cutSize] = t[i-1][cutSize];
            }
        }
        return t[rodLength][rodLength];
    }
}
