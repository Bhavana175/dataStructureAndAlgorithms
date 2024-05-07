package com.workspace.learning.interviews.goldmansachs.practice;

import java.util.ArrayList;
import java.util.Arrays;
/*
* == Instructions ==

 ** There is a staircase with 'n' number of steps. A child
 ** walks by and wants to climb up the stairs, starting at
 ** the bottom step and ascending to the top.

 ** Of course, the child wants to have fun, too, so instead
 ** of taking 1 step at a time, it will vary between taking
 ** either 1, 2 or 3 steps at a time.

 ** Please complete the 'countSteps' method below so that
 ** given 'n' number of steps it will return the number of
 ** unique combinations the child could traverse.

 ** An example would be countSteps(3) == 4:

 ** 1 1 1
 ** 2 1
 ** 1 2
 ** 3
 */

public class CountSteps {
    // Iterative linear solution
    public static Integer countSteps(Integer n)
    {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;

        ArrayList<Integer> counts = new ArrayList<>(Arrays.asList(0, 1, 2, 4));

        for(int i = 4; i <= n; ++i)
        {
            counts.add(counts.get(i - 1) + counts.get(i - 2) + counts.get(i - 3));
        }

        return counts.get(n);
    }


    /**
     * Returns true if the tests pass. Otherwise, false.
     */
    public static boolean doTestsPass()
    {
        // todo: implement more tests if you'd like

        return countSteps(3) == 4
                && countSteps(4) == 7
                && countSteps(1) == 1
                && countSteps(2) == 2
                && countSteps(0) == 0
                && countSteps(-5) == 0
                && countSteps(10) == 274
                && countSteps(36) == 2082876103; // Will cause naive solution to time-out
    }


    /**
     * Execution entry point.
     */
    public static void main(String[] args)
    {
        // Run the tests
        if(doTestsPass())
        {
            System.out.println("All tests pass");
        }
        else
        {
            System.out.println("Tests fail.");
        }

        // Try some examples
        for (Integer n = 1; n <= 5; n++)
        {
            Integer numberOfCombinations = countSteps(n);
            System.out.println(n + " steps => " + numberOfCombinations);
        }
    }
}
