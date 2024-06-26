package com.workspace.learning.interviews.epampractice;
import java.util.Arrays;

public class SecondLargestElement {

    public static void main(String[] args) {

        int [] arr = {500,99,50,78,6317,55};
        // java 8
        int secondLargest = Arrays.stream(arr)
                .mapToObj((num)-> (int) num)
                .sorted((a,b)->b-a)
                .skip(1).findFirst()
                .orElseGet(() -> 0);

        System.out.println(secondLargest);

        System.out.println(secondLargestElement(arr));

    }

    private static int secondLargestElement(int[] arr) {

        int max = Integer.MIN_VALUE;
        int ans = max;

        for (int i = 0; i < arr.length; i++) {

            if(max<arr[i]){
                ans = max;
                max = arr[i];
            }

        }

        return ans;
    }

}
