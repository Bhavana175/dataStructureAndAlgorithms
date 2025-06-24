package leetcode.dailyquestion.dp;

public class CountOfSubsetSum {
    public static void main(String[] args) {
        System.out.println(countSubsetSumForGivenSum(new int [] {2,3,5,8,10,5}, 10));

    }
    public static int countSubsetSumForGivenSum(int [] nums, int sum ){

        int n = nums.length;
        int [][] t = new int[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(i==0){
                    t[i][j]=0;
                }
                if(j==0){
                    t[i][j]=1;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int sumj = 1; sumj < sum+1; sumj++) {
                if(nums[i-1]<=sumj){
                    t[i][sumj] = t[i-1][sumj-nums[i-1]] + t[i-1][sumj];
                }else  t[i][sumj] = t[i-1][sumj];
            }
        }

        return t[n][sum];
    }
}
