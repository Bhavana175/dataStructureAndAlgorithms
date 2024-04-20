package com.workspace.learning.interviews.goldmansachs.practice;

import java.util.Arrays;

public class AddFractions {

    /**
     * int[] addFractions ( int[] fraction1, int[] fraction2 )
     * <p>
     * Given two fractions passed in as int arrays,
     * returns the fraction which is result of adding the two input fractions.
     * Fraction is represented as a two-element array - [ numerator, denominator ]
     * The returned fraction has to be in its simplest form.
     */

    public static void main(String[] args) {
        AddFractions obj = new AddFractions();
        try {
            int[] result = obj.addFractions(new int[]{2, 3}, new int[]{1, 2});
            System.out.println(Arrays.toString(result));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            int[] result1 = obj.addFractions(new int[]{5, 6}, new int[]{2, 3});
            System.out.println(Arrays.toString(result1));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            int[] result2 = obj.addFractions(new int[]{2, 3}, new int[]{1, 0});
            System.out.println(Arrays.toString(result2));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            int[] result3 = obj.addFractions(new int[]{2}, new int[]{1, 2});
            System.out.println(Arrays.toString(result3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private int[] addFractions(int[] a, int[] b) {
        int[] c = new int[2];

        if (a.length != 2 || b.length != 2) {
            throw new IllegalArgumentException("length !=2 , failed");
        }
        if (a[1] == 0 || b[1] == 0) {
            throw new IllegalArgumentException("failed");
        } else {
            c[0] = (a[0] * b[1]) + (a[1] * b[0]);
            c[1] = a[1] * b[1];
        }
        int gcd = findGreatestCommonDivisor(c);

        return new int[]{c[0] / gcd, c[1] / gcd};
    }

    private int findGreatestCommonDivisor(int[] c) {

        int gcd = Math.min(c[0], c[1]);

        if (gcd != 0) {
            while (gcd > 0) {
                if (c[0] % gcd == 0 && c[1] % gcd == 0) {
                    break;
                }
                gcd--;
            }
        } else {
            gcd = 1;
        }

        return gcd;
    }

}
