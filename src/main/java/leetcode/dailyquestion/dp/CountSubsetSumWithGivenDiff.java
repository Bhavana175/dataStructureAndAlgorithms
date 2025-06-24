package leetcode.dailyquestion.dp;

public class CountSubsetSumWithGivenDiff {
    public static void main(String[] args) {
        System.out.println(countSubsetSumWithGivenDiff(new int []{1,1,2,3}, 1));
    }
    public static int countSubsetSumWithGivenDiff(int [] nums, int diff){
        //s1-s2 = diff, s1+s2 = sumAll ===>.  2s1 = diff+sumAll ==> s1 = (diff+sumAll)/2
        // reduced to count subsetSum problem

        int sumALL = 0;
        for(int num: nums){
            sumALL += num;
        }

        int s1 = (diff+sumALL)/2;
        int n = nums.length;
        int [][] t = new int[n+1][s1+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < s1+1; j++) {
                if(i==0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int sumj = 1; sumj < s1+1; sumj++) {
                if(nums[i-1]<=sumj){
                    t[i][sumj] = t[i-1][sumj-nums[i-1]] + t[i-1][sumj];
                }else  t[i][sumj] = t[i-1][sumj];

            }
        }

        return t[n][s1];
    }
}
