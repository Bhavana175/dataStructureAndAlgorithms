package leetcode.dailyquestion.dp.lcs;

public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int []  nums = {10,9,2,5,3,7,101,18};

        //Output: 4
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int [][] t = new int[n+1][n+1];

        //base condition n=0, output  0, n=1, output =1,
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(j==0 || i==0){
                    t[i][j] = 1;
                }
            }
        }
        int max =0;
        for (int i = 1; i <n+1 ; i++) {
            for (int j = i; j < n+1; j++) {

                if(nums[i-1]<nums[j-1]){
                    t[i][j] = Math.max(1+ t[i-1][j-1], t[i-1][j]);
                    max = Math.max(max, t[i][j]);
                }else t[i][j] =t[i][j-1];
            }
        }
        return max;
    }
}
