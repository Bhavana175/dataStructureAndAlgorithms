package com.workspace.learning.algorithms.array;

import java.util.Arrays;

public class RemoveElement {

    /**
     * https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
     */

    public int removeElement(int[] nums, int val) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val) {
                nums[i] = Integer.MAX_VALUE;
            } else {
                k++;
            }
        }
        Arrays.sort(nums);
        return k;
    }
}
