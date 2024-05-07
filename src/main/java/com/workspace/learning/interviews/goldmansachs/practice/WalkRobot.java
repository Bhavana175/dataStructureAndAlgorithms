package com.workspace.learning.interviews.goldmansachs.practice;

import java.util.Arrays;

// Instructions to candidate
//
// 1. Run this code in the REPL to observe its behaviour. The
//    execution entry point is main().
// 2. Implement the 'walk' method. This method takes in a string, path,
//    where each character in the string corresponds to a potential movement
//    of the robot. The robot can move up, down, left, and right represented
//    by the characters 'U', 'D', 'L', and 'R' respectively. All other
//    characters may be ignored. Assume the robot's initial position
//    is at (0,0). The output of this method is the robot's final x and y
//    coordinates relative to the initial position.
// 3. Consider adding more test cases
public class WalkRobot {

    public static Integer[] walk(String path) {
       Integer [] currentP = new Integer[]{0, 0};
        if(path==null){
            return currentP;
        }
        for (char ch:path.toUpperCase().toCharArray()
             ) {
            switch (ch) {
                case 'U' -> currentP[1] += 1;
                case 'D' -> currentP[1] -= 1;
                case 'L' -> currentP[0] -= 1;
                case 'R' -> currentP[0] += 1;
                default -> {
                }
            }
        }

        return currentP;
    }

    public static boolean checkEqual(Integer[] a, Integer[] b) {
        return Arrays.equals(a, b);
    }

    /**
     * public static boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false
     */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        boolean res = true;

        {
            String test = "UUU";
            Integer[] result = walk(test);
            res &= checkEqual(result, new Integer[]{0, 3});
        }

        {
            String test = "ULDR";
            Integer[] result = walk(test);
            res &= checkEqual(result, new Integer[]{0, 0});
        }

        {
            String test = "ULLLDUDUURLRLR";
            Integer[] result = walk(test);
            res &= checkEqual(result, new Integer[]{-2, 2});
        }

        {
            String test = "UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP";
            Integer[] result = walk(test);
            res &= checkEqual(result, new Integer[]{1, 1});
        }

        return res;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}
