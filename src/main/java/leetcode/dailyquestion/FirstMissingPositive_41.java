package leetcode.dailyquestion;

import java.util.Arrays;

public class FirstMissingPositive_41 {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {

        Arrays.sort(nums);
       // int[] nums = { -1, 1, 3, 4};
        if(nums[0]>0 && nums[0] !=1){
            return 1;
        }

        int l =0; int r= nums.length-1;

        while (l<= r && nums[l]<1){




        }

    }
}
