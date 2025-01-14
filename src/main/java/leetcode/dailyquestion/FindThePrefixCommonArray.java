package leetcode.dailyquestion;

import java.util.Arrays;
import java.util.HashSet;

public class FindThePrefixCommonArray {

    //    https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{1, 2, 3}, new int[]{1, 3, 2})));
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] arr = new int[A.length];
        int count = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (!set.add(A[i])) {
                count++;
            }
            if (!set.add(B[i])) {
                count++;
            }
            arr[i] = count;
        }
        return arr;
    }

}
