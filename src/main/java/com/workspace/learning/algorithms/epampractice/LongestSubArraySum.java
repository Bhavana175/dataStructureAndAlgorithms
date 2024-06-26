package com.workspace.learning.algorithms.epampractice;

import java.util.HashMap;

public class LongestSubArraySum {

    /*
     Find the length of Longest sub-array which has sum = targetSum
               int[] arr = {15, -2, 2, -3, 1, 3, 3, 0};

      int targetSum = 4;
      output: 7
     */

    public static void main(String[] args) {
        int[] arr = {15, -2, -4, 2, -3, 1, 3, 3, 0,4};
        int k= 4;
        LongestSubArraySum obj = new LongestSubArraySum();

        System.out.println(obj.getMaxLenForSubArray(arr, k));


    }

    private int getMaxLenForSubArray(int[] arr, int k) {
        int maxLen=0;
        int sum=0;
        HashMap<Integer,Integer> map = new HashMap<>();

        //key = sum, val = firstIndex, maxLen=i- firstIndex

        for(int i=0; i<arr.length; i++){
            sum= sum+ arr[i];
            if(map.containsKey(sum-k)){
                maxLen= Math.max(maxLen, i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                //first index
                map.put(sum, i);
            }

        }

        return maxLen;
    }

}
