package com.workspace.learning.interviews.epampractice;

import java.util.ArrayList;
import java.util.List;

public class SortedOrderMatrix {

    public static void main(String[] args) {

        int[][] arr = {{10, 20, 30, 40},
                {15, 20, 35, 42},
                {27, 29, 37, 46},
                {32, 33, 38, 49}};

        List<Integer> list = sortedMatrixElement(arr);
        System.out.println(list);
    }

    private static List<Integer> sortedMatrixElement(int[][] arr) {

        int[] temp = new int[arr.length]; // row
        int counter = 0;

        List<Integer> list = new ArrayList<>();
        while (counter < arr.length) {
            int min = Integer.MAX_VALUE, minIndex = 0;
            for (int row = 0; row < arr.length; row++) {
                if (temp[row]<arr[row].length && min >= arr[row][temp[row]]) {
                    min = arr[row][temp[row]];
                    minIndex=row;
                }
            }
            list.add(min);
            temp[minIndex]++;
            if (temp[minIndex] == arr[minIndex].length) {
                counter++;
            }
        }
        return list;
    }

}
