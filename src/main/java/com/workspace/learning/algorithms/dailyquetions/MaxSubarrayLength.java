package com.workspace.learning.algorithms.dailyquetions;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayLength {

    //https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/?envType=daily-question&envId=2024-03-28

    public static void main(String[] args) {
        int [] nums = {1,4,4,3};
        int k = 1;

        MaxSubarrayLength obj = new MaxSubarrayLength();
        System.out.println("output : "+obj.maxSubarrayLength(nums,k));
        System.out.println("output : "+obj.maxSubarrayLength(new int[]{5,5,5,5,5,5,5},4));
    }
    public int maxSubarrayLength(int[] nums, int k) {
        int maxSubLen=0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0,start=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.get(nums[i])>k) {
                map.put(nums[start], map.getOrDefault(nums[i], 0) - 1);
                start++;
            }
            maxSubLen = Math.max(maxSubLen,i-start+1);
        }
        return maxSubLen;
    }
}
