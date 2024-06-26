package com.workspace.learning.interviews.paypalpractice;

import java.util.Arrays;

public class ArrayRotate {

    /*
    arr = {2,3,4,5,6}  output= 5,6,2,3,4
    rotate by d= 3;
    reverse first 3
    4,3,2,5,6
    reverse last 2
    4,3,2,6,5
    reverse all
    ans : 5,6,2,3,4

    left rotate
    right rotate?
    */
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        //left rotate 3,4,5,6,7,1,2
        int d = 2;

        leftRotate(arr, d);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};

        leftRotate(arr2, 4);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1, 2, 3, 4, 5, 6, 7};

        System.out.println("right :"+Arrays.toString(arr3));
        rightRotate(arr3, 2);
        System.out.println(Arrays.toString(arr3));
    }

    private static void rightRotate(int[] arr, int d) {
        int n = arr.length;
        reverse(arr, 0, n-d - 1);
        reverse(arr, n-d, n - 1);
        reverse(arr, 0, n - 1);


    }

    private static void leftRotate(int[] arr, int d) {

        int n = arr.length;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);

    }

    private static void reverse(int[] arr, int i, int j) {

        while (i <= j) {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }

}
