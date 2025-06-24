package leetcode.dailyquestion.dp;

import java.util.ArrayList;

public class MinSubsetSubDiff {
    public static void main(String[] args) {
        int [] nums = {2,6,11,5};
        System.out.println(finsMinSubsetArrSumDiff(nums));
    }

    public static int finsMinSubsetArrSumDiff(int[] nums) {

        //s2-s1 = minimum
        // s1+s2 = SUM(all elements)
        // SUM - 2s1 = minimum

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sum1 = sum/2;
        int n = nums.length;

        boolean [][] t = new boolean[n+1][sum1+1];

        for (int i = 0; i <n+1 ; i++) {
            for (int j = 0; j < sum1+1; j++) {
                if(i==0){
                    t[i][j] = false;
                }
                if(j==0){
                    t[i][j] = true;
                }
            }
        }


        for (int i = 1; i < n+1; i++) {
            for (int sumj = 1; sumj < sum1+1; sumj++) {
                if(nums[i-1]<= sumj){
                    t[i][sumj] = t[i-1][sumj-nums[i-1]] || t[i-1][sumj];
                }else  t[i][sumj] = t[i-1][sumj];
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int index =0;
        for (int j=0; j<sum1+1; j++ ){
            if(t[n][j]){
                arrayList.add(index, j);
                index++;
            }
        }
        int min = Integer.MAX_VALUE;

        for (int val : arrayList) {
            min = Math.min(min, sum-2*(val));
        }

        return min;
    }
}
