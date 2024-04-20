package com.workspace.learning.algorithms.dailyquetions;


public class FirstMissingPositive {
    //https://leetcode.com/problems/first-missing-positive/?envType=daily-question&envId=2024-03-26

/*  Given an unsorted integer array nums. Return the smallest positive integer that
    is not present in nums.
    You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
    Input: nums = [1,2,0]
    Output: 3
    Explanation: The numbers in the range [1,2] are all in the array.
    */
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7,8,9,10,100};
        FirstMissingPositive obj = new FirstMissingPositive();
        int output = obj.firstMissingPositive(nums);
        System.out.println("output  : "+output);

    }
    public int firstMissingPositive(int[] nums) {

        //first missing positive integer

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;

        return n + 1;


    }
}
