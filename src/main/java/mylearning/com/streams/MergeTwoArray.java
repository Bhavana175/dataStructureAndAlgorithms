package mylearning.com.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeTwoArray {

    /**
     * ow do you merge two unsorted arrays into single sorted array using Java 8 streams?
     */

    public static void main(String[] args) {

        int[] a = new int[] {4, 2, 7,7,9,8 ,1};
        int[] b = new int[] {8, 3, 9, 5,6};

        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
        System.out.println(Arrays.toString(c));

        // How do you merge two unsorted arrays into single sorted array without duplicates?
        int[] d = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();
        System.out.println(Arrays.toString(d));
    }

}
