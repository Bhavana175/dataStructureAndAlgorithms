package com.workspace.learning.interviews.goldmansachs.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAverageGrade {

    /**
     * Instructions:
     * <p>
     * Given a list of student test scores, find the best average grade.
     * Each student may have more than one test score in the list.
     * <p>
     * Complete the bestAverageGrade function in the editor below.
     * It has one parameter, scores, which is an array of student test scores.
     * Each element in the array is a two-element array of the form [student name, test score]
     * e.g. [ "Bobby", "87" ].
     * Test scores may be positive or negative integers.
     * <p>
     * If you end up with an average grade that is not an integer, you should
     * use a floor function to return the largest integer less than or equal to the average.
     * Return 0 for an empty input.
     * <p>
     * Example:
     * <p>
     * Input:
     * [ [ "Bobby", "87" ],
     * [ "Charles", "100" ],
     * [ "Eric", "64" ],
     * [ "Charles", "22" ] ].
     * <p>
     * Expected output: 87
     * Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
     * respectively. 87 is the highest.
     */

    /*
     **  Find the best average grade.
     */
    public static Integer bestAverageGrade(String[][] scores) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        final double[] maxAvg = {Integer.MIN_VALUE};
        if(scores == null || scores.length==0|| scores[0].length!=2){
            return 0;
        }
        for (int i = 0; i < scores.length; i++) {
            List<Integer> list = new ArrayList<>();
            if (map.containsKey(scores[i][0])) {
                list = map.get(scores[i][0]);
            }
            list.add(Integer.parseInt(scores[i][1]));
            map.put(scores[i][0], list);
        }

        map.forEach((k, l) -> {
            l.stream().mapToDouble(num -> num.doubleValue())
                    .average().ifPresentOrElse(
                            avg -> {maxAvg[0] = Math.max(maxAvg[0], avg);},
                            () -> System.out.println("notfound"));

        });

        return (int) Math.floor(maxAvg[0]);
    }

    /*
     **  Returns true if the tests pass. Otherwise, returns false;
     */
    public static boolean doTestsPass() {
        // TODO: implement more test cases
        // map of test cases to expected results
        Map<String[][], Integer> testCases = new HashMap<>();

        // example
        testCases.put(new String[][] { { "Bobby", "87" },
                        { "Charles", "100" },
                        { "Eric", "64" },
                        { "Charles", "22" } },
                87);
        // empty
        testCases.put(new String[][] {},
                0);
        // multiple scores each
        testCases.put(new String[][] { { "Sarah", "91" },
                        { "Goldie", "92" },
                        { "Elaine", "93" },
                        { "Elaine", "95" },
                        { "Goldie", "94" },
                        { "Sarah", "93" } },
                94);
        // negatives and zeros
        testCases.put(new String[][] { { "Janie", "-66" },
                        { "Janie", "0" },
                        { "Gina", "-88" },
                        { "Bobby", "0" },
                        { "Gina", "44" },
                        { "Bobby", "0" },
                        { "Bobby", "-6" } },
                -2);
        // same value and average
        testCases.put(new String[][] { { "Alpha", "99" },
                        { "Bravo", "99" },
                        { "Charlie", "99" },
                        { "Delta", "99" },
                        { "Echo", "99" },
                        { "Foxtrot", "99" },
                        { "Foxtrot", "99" } },
                99);
        // non-integer average
        testCases.put(new String[][] { { "Gerald", "91" },
                        { "Gerald", "92" } },
                91);
        // negative non-integer average
        testCases.put(new String[][] { { "Barry", "-66" },
                        { "Barry", "-65" },
                        { "Alfred", "-122"} },
                -66);

        boolean passed = true;
        for(Map.Entry<String[][], Integer> entry : testCases.entrySet())
        {
            Integer actual = bestAverageGrade(entry.getKey());
            if(actual != entry.getValue())
            {
                passed = false;
                System.out.println("Failed for " + Arrays.deepToString(entry.getKey()) + "\n  expected " + entry.getValue() + ", actual " + actual);
            }
        }


        return passed;
    }

    /*
     **  Execution entry point.
     */
    public static void main(String[] args) {
        // Run the tests
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("Tests fail.");
        }
    }
}
