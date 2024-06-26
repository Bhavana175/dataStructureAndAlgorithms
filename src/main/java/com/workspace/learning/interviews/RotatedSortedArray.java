package com.workspace.learning.interviews;

public class RotatedSortedArray {
    //https://leetcode.com/problems/search-in-rotated-sorted-array/description/

    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        int l=0, r= nums.length-1;

       while (l<=r) {
           int mid = l + r / 2;

           if (nums[mid] == target) {
               return mid;
           } else if (nums[mid]<target && nums[mid]<nums[mid+1] && nums[mid]<nums[r]){

               l=mid+1;
           }

       }


return 0;
    }
}
