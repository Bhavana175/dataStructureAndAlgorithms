package com.workspace.learning.interviews.walmartpractice;

public class SearchElement {

    public static void main(String[] args) {



    }

    public static int search(int[] nums, int target) {
        int l=0, r= nums.length-1;

        //4 5 6 7  0 1 2 3  t=1

        while (l<=r){

            int mid = (l+r)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[l]< nums[mid]){

                if(nums[l]<=target && target<nums[mid]){
                    r= mid-1;
                }else {
                    l=mid+1;
                }

            }else {
                if(nums[mid]<target && target<=nums[r]){
                    l= mid+1;
                }else {
                    r=mid-1;
                }

            }

        }
        return -1;
    }
}
