package leetcode.dailyquestion;

import java.util.Arrays;

public class RemoveDuplicate26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int [] {1,1,2}));
    }
    public static int removeDuplicates(int[] nums) {
        int k=0;
        int start =0;
        for(int i=0; i<nums.length; i++){
            int val = nums[i];
            start = i+1;
            while(start<nums.length && val==nums[start]){
                nums[start] = Integer.MAX_VALUE;
                start++;
                k++;
            }
            i=start-1;
        }
        Arrays.sort(nums);
        return k;
    }
}
