package com.workspace.learning.interviews.paypalpractice;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {20, 30, 35, 88, 89, 96, 99, 100, 102, 117, 150, 200, 355};
        int search = 150;
        int index = binarySearch(arr, search);
        System.out.println(index);
        int index1 = binarySearch(arr, 88);
        System.out.println(index1);
    }

    private static int binarySearch(int[] arr, int search) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == search) {
                return mid;
            } else if (search< arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

}
