package com.workspace.learning.interviews.goldmansachs.practice;

import java.util.Arrays;

/*
 ** Instructions to candidate.
 **  1) Given an array of non-negative integers representing the elevations
 **     from the vertical cross section of a range of hills, determine how
 **     many units of snow could be captured between the hills.
 **
 **     See the example array and elevation map below.
 **                                 ___
 **             ___                |   |        ___
 **            |   |        ___    |   |___    |   |
 **         ___|   |    ___|   |   |   |   |   |   |
 **     ___|___|___|___|___|___|___|___|___|___|___|___
 **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 **                                 ___
 **             ___                |   |        ___
 **            |   | *   *  _*_  * |   |_*_  * |   |
 **         ___|   | *  _*_|   | * |   |   | * |   |
 **     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
 **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
 **
 **     Solution: In this example 13 units of snow (*) could be captured.
 **
 **  2) Consider adding some additional tests in doTestsPass().
 **  3) Implement computeSnowpack() correctly.
 */
public class SnowPack {

    /*
     **  Find the amount of snow that could be captured.
     */
    public static Integer computeSnowpack(Integer[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int total = 0;

        int left_highest[] = new int[arr.length];
        int left_max = 0;
        int right_max = 0;

        for (int i = 0; i < arr.length; i++) {
            left_max = Math.max(left_max, arr[i]);
            left_highest[i] = left_max;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            right_max = Math.max(right_max, arr[i]);
            if(Math.min(right_max, left_highest[i]) > arr[i])
                total += Math.min(right_max, left_highest[i]) - arr[i];
        }


        System.out.println(Arrays.toString(arr) + ' ' + total);
        return total;

    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        boolean result = true;
        result &= computeSnowpack(new Integer[]{0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0}) == 13;

        return result;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}
