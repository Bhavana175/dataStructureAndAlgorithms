package mylearning.com.InterviewQuestion;

// Java program to check if there exists a pair
// in array whose sum results in x.

import java.util.Arrays;
import java.util.stream.IntStream;

class PairSumArray {

    // Function to find and print pair
    static boolean chkPair(int A[], int size, int x)
    {
        for (int i = 0; i < (size - 1); i++) {
            for (int j = (i + 1); j < size; j++) {
                if (A[i] + A[j] == x) {
                    System.out.println("pair : "+ A[i]+ " , "+ A[j]);
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args)
    {

        int A[] = { 0, -1, 2, -3, 1 };
        int x = -2;
        int size = A.length;

        Arrays.stream(A)
                .flatMap(i-> IntStream.of(i*10))
                .forEach(System.out::println);


        Arrays.stream(A)
                .map(j->j*10)
                .forEach(System.out::println);

        if (chkPair(A, size, x)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
