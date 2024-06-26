package com.workspace.learning.interviews.jpmorganpractice;

import java.util.Arrays;

public class NextPermutation {
    //https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    //https://leetcode.com/problems/next-permutation/description/

    public static void main(String[] args) {

        int[] arr = {5,1,1};
        nextPermutation(arr);

    }

    public static void nextPermutation(int[] nums) {

        int len = nums.length;
        int pivot = 0;
        boolean isPivot = false;

        //find pivot
        for (int i = len-1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivot = i;
                isPivot = true;
                break;
            }
        }
        if (isPivot) {
            for (int i = len-1; i >= pivot; i--) {
                if (nums[pivot-1] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[pivot-1];
                    nums[pivot-1] = temp;
                    break;
                }
            }
        }

        for (int i = pivot, j = len-1;  i<j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        System.out.println(Arrays.toString(nums));
    }
}
