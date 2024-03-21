package com.workspace.learning.algorithms.array;

import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SubArraySum {

    /**
     * Given an array of integers nums and an integer k,
     * return the total number of subarrays whose sum equals to k.
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * <p>
     * Input: nums = [1,2,3], k = 3
     * Output: 2
     */

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 3, -2};
        int k = 3;

        SubArraySum obj = new SubArraySum();
        System.out.println("output :" + obj.subarraySum(nums, k));
        System.out.println("output :" + obj.subarraySum(new int[]{1, 2, 3, -2, 3, -1, 1, 7}, 3));
        System.out.println("output :" + obj.subArraySum(new int[]{1, 2, 3, 0,-2, 3, -1, 1, 7,-4}, 3, 0));
        List<List<Integer>> list = obj.getListOfSubArraySum(new int[]{ 1, 2, 3, -2}, 3);

    }

    private List<List<Integer>> getListOfSubArraySum(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> subArrayList = new ArrayList<>();
        int sum =0, index=0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);

        for (int i=0; i<nums.length; i++){

            sum+=nums[i];
            if(hm.containsKey(sum-k)){
                index= hm.get(sum-k);

                System.out.println("index"+index);
            }
                hm.put(sum,i);

        }


        return subArrayList;
    }

    /**
     * time complexity O(n2)
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {

        int counter = 0, len = nums.length, sum = 0;

        for (int j = 0; j < len; j++) {

            sum = nums[j];

            if (sum == k) {
                counter++;
            }

            for (int i = j + 1; i < len; i++) {
                {
                    sum = sum + nums[i];
                    if (sum == k) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public int subArraySum(int[] nums, int k, int sum) {
        HashMap<Integer, Integer> sumfreq = new HashMap<>();
        int counter = 0;
        sumfreq.put(0, 1);

        for (int val : nums) {
            sum += val;
            if (sumfreq.containsKey(sum - k)) {
                counter += sumfreq.get(sum - k);
            }
            sumfreq.put(sum, sumfreq.getOrDefault(sum, 0) + 1);
        }
        return counter;
    }

}
