package com.workspace.learning.interviews.goldS.practice;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseString {

    /**
     * public static String reverseStr( String str )
     * Takes String str and returns a new String
     * such that the characters are in reversed order.
     * Example: reverseStr(str) where str is "abcd" returns "dcba".
     */
    public static String reverseStr(String str) {
       // abc----bac-> bca--->cba
       /* return str.chars()                    // Convert the string to an IntStream of characters
                .mapToObj(c -> (char) c)    // Convert each character to a Character object
                .collect(Collectors.toList()) // Collect them into a List
                .stream()                    // Get a Stream<Character> from the List
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1); // Reduce the stream by concatenating each character in reverse order
*/

        StringBuilder sb = new StringBuilder();

        for (int i = str.length()-1; i >=0 ; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
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
        result = result && reverseStr("odd abcde").equals("edcba ddo");
        result = result && reverseStr("even abcde").equals("edcba neve");
        result = result && reverseStr(reverseStr("no change")).equals("no change");
        result = result && reverseStr("").equals("");
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
