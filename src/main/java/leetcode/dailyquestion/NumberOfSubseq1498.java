package leetcode.dailyquestion;

import java.util.Arrays;

public class NumberOfSubseq1498 {
    public static void main(String[] args) {
        int [] nums = {3,5,6,7};
        int target = 9;
        System.out.println(numSubseq(nums,target));
        //Output: 4
    }
    public static int numSubseq(int[] nums, int target) {

        int count =0;
        int n = nums.length;

        Arrays.sort(nums);


        for (int i = 0; i < n; i++) {


        }
        return count;
    }
}



