package com.workspace.learning.algorithms.epampractice;

import java.util.HashMap;

public class ArraySumForTarget {

    /*
     Given an array of integers nums and an integer k,
     return the total number of subarrays whose sum equals to k.
     A subarray is a contiguous non-empty sequence of elements within an array.

     Input: nums =  [1,2,0,3], k = 3
     hashmap key val    sum  =[0,1,3,3,6]
     sum-k= [-2,0,0,3]
     first index =0,i
     print sub array;
     Output: 4
     */

    public static void main(String[] args) {

        ArraySumForTarget obj = new ArraySumForTarget();
        int [] nums =  {1,2,3,-2,3,-1,1,7,-4};
        int k= 3;
        System.out.println( obj.getSubArray(nums, k));

    }

    private int getSubArray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int count=0;
        int sum=0;
        map.put(0,1);

        for(int i=0; i<nums.length; i++){

            sum+=nums[i];

            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);

        }
        return count;

    }

}
