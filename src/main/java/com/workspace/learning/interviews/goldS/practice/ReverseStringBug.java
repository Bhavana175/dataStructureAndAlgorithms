package com.workspace.learning.interviews.goldS.practice;

public class ReverseStringBug {

    /**
     * public static String reverseStr( String str )
     * Takes String str and returns a new String
     * such that the characters are in reversed order.
     * Example: reverseStr(str) where str is "abcd" returns "dcba".
     */
    public static String reverseStr(String str) {

        if (str.length() == 1) {
            return str;
        }

        int strLength = str.length() - 1;
        StringBuilder sb = new StringBuilder(strLength);

        for (int i = strLength; i >= 0; i-- ) {
            sb.append(str.charAt(i));
           // strLength += i;
        }


        return sb.toString();
    }

    ;

    /**
     * public static boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false
     */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        String testString;
        String solution;
        boolean result = true;

        result = result && reverseStr("abcd").equals("dcba");

        return result;
    }

    ;

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
