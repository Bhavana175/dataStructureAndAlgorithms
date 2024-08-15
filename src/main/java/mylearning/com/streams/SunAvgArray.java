package mylearning.com.streams;

import java.util.Arrays;

public class SunAvgArray {

    /**
     * Given an integer array, find sum and average of all elements?
     * @param args
     */
    public static void main(String[] args) {

       // int[] a = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
        int[] a = new int[] {10,20};
        Integer sum = Arrays.stream(a).sum();
        System.out.println(sum);

        Double avg = Arrays.stream(a).average().getAsDouble();
        System.out.println(avg);
    }

}
