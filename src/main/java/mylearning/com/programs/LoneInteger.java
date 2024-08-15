package mylearning.com.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoneInteger {


    public static void main(String args[]) {

        int [] A = {1,-8,-5,-6,-7,-8,-9,-10,-4,-3,-2};
        int solution = solution(A);
        System.out.println("ans : "+solution);
    }

        public static int solution ( int[] a){
            // write your code in Java SE 8

            int n = a.length;
            int positiveInteger = 0;
            boolean flag = true;

            do {
                positiveInteger++;
                for (int i = 0; i < n; i++) {
                    if (-1000000 < a[i] && a[i] < 1) {
                        flag = false;
                    }else
                    {flag = true;}
                    if (0 < a[i] && a[i] < 1000000) {
                        if (positiveInteger == a[i]) {
                            flag = true;
                            break;
                        }else{
                            flag = false;
                        }
                    }
                }
            } while (flag);
return positiveInteger;
        }

    }

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

 /*   class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 8

            int n = A.length;
            int positiveInteger = 0;
            boolean flag = true;
            int negativeRange = -1000000;

            do {
                positiveInteger++;
                for (int i = 0; i < n; i++) {
                    if (-1000000 < A[i] && A[i] < 1) {
                        // positiveInteger = 1;
                        flag = false;
                    }
                    if (0 < A[i] && A[i] < 1000000) {
                        if (positiveInteger != A[i]) {
                            flag = false;
                        }
                    }
                }
            } while (flag);

        }
    }
*/
