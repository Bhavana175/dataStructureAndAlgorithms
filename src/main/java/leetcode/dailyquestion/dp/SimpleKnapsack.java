package leetcode.dailyquestion.dp;

public class SimpleKnapsack {
    public static void main(String[] args) {
        int [] val = {2,4,6,8};
        int [] wt = {5,2,7,4};
        int W = 14;
        int n =4;
        System.out.println(findMaxProfit(wt,val,W,n));
        System.out.println(findMaxProfitTopDown(wt,val,W, n));
    }
    public static int findMaxProfit(int [] wt, int[] val , int W, int n ){
       return knapSackRec(wt, val, W, n);
    }

    private static int knapSackRec(int[] wt, int[] val, int W, int n) {
        if(n==0 || W ==0){
            return 0;
        }
        if(wt[n-1] <= W){
            return  Math.max(val[n-1]+ knapSackRec(wt, val, W-wt[n-1], n-1),
                    knapSackRec(wt, val, W, n-1));
        }else return knapSackRec(wt, val, W, n-1);
    }

    public static int findMaxProfitTopDown(int [] wt, int[] val , int W, int n ){

        int [][] t = new int[n+1][W+1];

        //base condition
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                if(i==0 || j == 0){
                    t[i][j]= 0;
                }
            }
        }

        //choice
        for (int i = 1; i <n+1 ; i++) {
            for (int knapSackWeight = 1; knapSackWeight < W+1; knapSackWeight++) {
                if(wt[i-1]<=knapSackWeight){
                    t[i][knapSackWeight] =
                            Math.max(val[i-1]+t[i-1][knapSackWeight-wt[i-1]], t[i-1][knapSackWeight] );
                }else t[i][knapSackWeight] =  t[i-1][knapSackWeight];
            }
        }

        return t[n][W];
    }
}
