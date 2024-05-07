package com.workspace.learning.interviews.goldmansachs.practice;

import java.util.Arrays;

public class SortedArrayMedian {

    public static double findMedianSortedArrays(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;
        int[] arr = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (A[i] < B[j]) {
                arr[k] = A[i];
                k++;i++;
            } else {
                arr[k] = B[j];
                k++;j++;
            }
        }

        while (i<m){
            arr[k]=A[i];
            k++; i++;
        }
        while (j<n){
            arr[k]=B[j];
            k++; j++;
        }

        if(arr.length%2==0){
           return  (arr[arr.length/2 - 1]+arr[arr.length/2])/2.0;
        }else {
            return arr[arr.length/2];
        }

    }

/*
    public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length) aMid = A[aStart + k / 2 - 1];
        if (bStart + k / 2 - 1 < B.length) bMid = B[bStart + k / 2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k / 2, B, bStart, k - k / 2);// Check: aRight + bLeft
        else
            return getkth(A, aStart, B, bStart + k / 2, k - k / 2);// Check: bRight + aLeft
    }
*/

    /**
     * boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        boolean result = true;
        result = result && findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
        result = result && findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) == 2.0;
        return result;
    }

    ;

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }

}
