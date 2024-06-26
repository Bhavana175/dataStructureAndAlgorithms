package com.workspace.learning.interviews.goldS.practice;

import java.util.ArrayList;
import java.util.HashSet;

public class UniqueTuples {

    /**
     * HashSet<String> uniqueTuples( String input, int len )
     * <p>
     * Given a string and size of the tuples, extracts all unique
     * tuples(substrings) of the given size.
     */

    public static HashSet<String> uniqueTuples(String input, int len) {
        // TODO: Implement solution
        HashSet<String> result = new HashSet<>();
        if (input != null && len > 0 && len <= input.length()) {
            for (int i = 0; (i + len) <= input.length(); i++) {
                String subStr = input.substring(i, i + len);
                result.add(subStr);
            }
        } else {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        return result;
    }

    /**
     * boolean doTestsPass()
     * Returns true if the tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        // TODO: implement some tests, please
        // we've included a trivial boilerplate

        boolean testPassed = true;
        HashSet<String> result = null;
        String inputString = null;

        System.out.println("Running Test #1.");
        try {
            result = uniqueTuples(inputString, 2);
            // reaching here means that the Exception was not thrown
            // indicating that the test failed
            System.out.println("Test #1 failed.");
            testPassed = false;
        } catch (IllegalArgumentException e) {

        }

        System.out.println("Running Test #2.");
        inputString = "abcde";
        try {
            result = uniqueTuples(inputString, 6);
            // reaching here means that the Exception was not thrown indicating that the test failed
            System.out.println("Test #2 failed.");
            testPassed = false;
        } catch (IllegalArgumentException e) {

        }

        System.out.println("Running Test #3.");
        try {
            result = uniqueTuples("", 2);
            // reaching here means that the Exception was not thrown indicating that the test failed
            System.out.println("Test #3 failed.");
            testPassed = false;
        } catch (IllegalArgumentException e) {

        }

        System.out.println("Running Test #4.");
        try {
            result = uniqueTuples("anything", 0);
            // reaching here means that the Exception was not thrown indicating that the test failed
            System.out.println("Test #4 failed.");
            testPassed = false;
        } catch (IllegalArgumentException e) {

        }

        System.out.println("Running Test #5.");
        inputString = "abbccde";
        result = uniqueTuples(inputString, 2);
        ArrayList<String> goodResult = new ArrayList<String>();
        goodResult.add("ab");
        goodResult.add("bb");
        goodResult.add("bc");
        goodResult.add("cc");
        goodResult.add("cd");
        goodResult.add("de");
        if (!(result.size() == 6 && result.containsAll(goodResult))) {
            System.out.println("Test #5 failed.");
            testPassed = false;
        }

        System.out.println("Running Test #6.");
        inputString = "aaabbb";
        result = uniqueTuples(inputString, 2);
        goodResult = new ArrayList<String>();
        goodResult.add("aa");
        goodResult.add("ab");
        goodResult.add("bb");
        if (!(result.size() == 3 && result.containsAll(goodResult))) {
            System.out.println("Test #6 failed.");
            testPassed = false;
        }

        if (testPassed) {
            System.out.println("All tests pass.");
        } else {
            System.out.println("There are test failures.");
        }

        return testPassed;
    }

    public static void main(String[] args) {
        doTestsPass();
    }
}
