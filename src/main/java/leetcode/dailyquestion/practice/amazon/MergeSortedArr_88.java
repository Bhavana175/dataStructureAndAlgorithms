package leetcode.dailyquestion.practice.amazon;

import java.util.Arrays;

public class MergeSortedArr_88 {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int [] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        int index1 = m-1;
        int index2 = n-1;
        while (index1>=0 && index2>=0){
            if(nums1[index1]>= nums2[index2]){
                nums1[index] = nums1[index1];
                index1--;
                index--;
            }else if(nums2[index2] > nums1[index1]){
                nums1[index] = nums2[index2];
                index2--;
                index--;
            }
        }

        while (index1 >=0){
            nums1[index] = nums1[index1];
            index1--;
            index--;
        }
        while (index2 >=0){
            nums1[index] = nums2[index2];
            index2--;
            index--;
        }
       // System.out.println(Arrays.toString(nums1));
    }

}
