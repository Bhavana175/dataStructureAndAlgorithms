package com.workspace.learning.algorithms.subarray;

public class SubArrayProductLessThnK {

    // https://leetcode.com/problems/subarray-product-less-than-k/description/?envType=daily-question&envId=2024-03-27
/*    Input: nums = [10,5,2,6], k = 100
    Output: 8
    Explanation: The 8 subarrays that have product less than 100 are:
            [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
    Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.*/

    public static void main(String[] args) {
        int[] nums = {57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
        int k = 18;
        SubArrayProductLessThnK obj = new SubArrayProductLessThnK();
        System.out.println(obj.numSubarrayProductLessThanK(nums, k));

    }

    private int numSubarrayProductLessThanK(int[] nums, int k) {

        if(k < 2)
            return 0;
        int count = 0;
        int product = 1;

        for (int i = 0, start = 0; i < nums.length; i++) {

                product *= nums[i];
                while (product >= k && start < nums.length) {
                    product = product / nums[start];
                    start++;

                }
                count += (i - start + 1);

        }

        return count;
    }

}
