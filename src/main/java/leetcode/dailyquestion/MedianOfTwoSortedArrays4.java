package leetcode.dailyquestion;

import java.util.Arrays;
import java.util.List;

public class MedianOfTwoSortedArrays4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArraysBinarySearch(nums1, nums2));

        List<Integer> list = Arrays.asList(1,56,7,8,32,78,90,7,9,0,1);
        List<Integer> integerList = list.stream().sorted((o1, o2) -> o2 - o1).limit(3).toList();


    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //time complexity O(log(m+n)) use binary search

        //Time Complexity O(m+n) for below
        int[] singleArr = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) singleArr[k++] = nums1[i++];
            else singleArr[k++] = nums2[j++];
        }
        while (i < nums1.length) singleArr[k++] = nums1[i++];
        while (j < nums2.length) singleArr[k++] = nums2[j++];
        if (singleArr.length % 2 == 1) return singleArr[singleArr.length / 2];
        else return (singleArr[singleArr.length / 2 - 1] + singleArr[singleArr.length / 2]) / 2.0;
    }

    public static double findMedianSortedArraysBinarySearch(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int totalLen = m + n;
        int half = totalLen / 2;
        int l1 = 0, r1 = m;

        while (l1 <= r1) {
            int partitionA = (l1 + r1) / 2;
            int partitionB = half - partitionA;

            int aLeft = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int aRight = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];

            int bLeft = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int bRight = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            if (aLeft <= bRight && bLeft <= aRight) {
                if (totalLen % 2 == 1) return Math.min(aRight, bRight);
                else return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
            } else if (aLeft > bRight) {
                r1 = partitionA - 1;
            } else l1 = partitionA + 1;
        }
        return 0.0;
    }


    public static int[] findSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] singleSortedArray = new int[len1 + len2];

        if (len1 == 0 && len2 == 0) {
            return new int[]{};
        } else if (len1 == 0) {
            return nums2;
        } else if (len2 == 0) {
            return nums1;
        }

        int indexA = len1 - 1;
        int indexB = len2 - 1;
        int index = singleSortedArray.length - 1;

        while (indexB >= 0) {
            if (indexA >= 0 && nums1[indexA] <= nums2[indexB]) {
                singleSortedArray[index] = nums2[indexB];
                index--;
                indexB--;
            } else if (nums1[indexA] > nums2[indexB]) {
                singleSortedArray[index] = nums1[indexA];
                index--;
                indexA--;
            }
        }

        if (index != 0 && indexA != 0) {
            while (indexA >= 0) {
                singleSortedArray[index] = nums1[indexA];
                index--;
                indexA--;
            }

        }
        return singleSortedArray;
    }

    private static double findMedian(int len, int[] arr) {
        double output;
        if (len % 2 == 0) {
            output = (double) (arr[(len - 1) / 2] + arr[(len + 1) / 2]) / 2;
        } else {
            output = arr[len / 2];
        }
        return output;
    }
}
