package com.workspace.learning.algorithms.subarray;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySum {

    /**
     * // Find the length of Longest sub-array which has sum = targetSum
     *          int[] arr = {15, -2, 2, -3, 1, 3, 3, 0};
     * Map key :       sum= {15, 13, 15, 12, 13, 16, 19, 19};
     * Map val:firstIndex = {0,  1,   0,  3,  1,  5,  6,  7}
     *          sum-k (4) = {11, 9, 11,  8, 9, 12, 15, 15 }
     * firstIndex=3,0,0
     * i=5, 6,7
     * maxLen= i-firstIndex= 2, 6, 7
     * <p>
     * <p>
     * <p>
     * // output = 7
     * int targetSum = 4;
     */

    public int getLongestSubArrayForSum(int[] arr, int targetSum) {
        int maxLen = Integer.MIN_VALUE;
        int sum = 0;

        Map<Integer, Integer> sumMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sumMap.containsKey(sum - targetSum)) {
                int firstIndex = sumMap.get(sum - targetSum);
                //if contains key thn calculate length
                maxLen = Math.max(maxLen, i - firstIndex);
            } else {
                if(!sumMap.containsKey(sum)){
                    //put only first index
                    sumMap.put(sum, i);
                }
            }

        }
        return maxLen;
    }


    public static void main(String[] args) {
        LongestSubArraySum obj = new LongestSubArraySum();
        int[] arr = {15, -2, 2, -3, 1, 3, 3, 0}; // output = 7
        int targetSum = 4;
        System.out.println(obj.getLongestSubArrayForSum(arr, targetSum));
    }

}
