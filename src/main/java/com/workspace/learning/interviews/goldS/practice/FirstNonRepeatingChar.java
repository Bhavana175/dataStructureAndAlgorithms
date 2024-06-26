package com.workspace.learning.interviews.goldS.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirstNonRepeatingChar {

    /**
     * char findFirst(String input)
     * Finds the first character that does not repeat anywhere in the input string
     * Given "apple", the answer is "a"
     * Given "racecars", the answer is "e"
     * Given "ababdc", the answer is "d"
     * <p>
     * hashMap<character, Count> [a, 1] , [p, 2, [l,1], [e,1]
     * iterate hashmap with keys in str list.len=1, return char
     **/
    public static char findFirst(String input) {
        if (input != null) {
            HashMap<Character, Integer> map = new HashMap<>();
            int len = input.length();
            char unique = ' ';

            for (int i = 0; i < len; i++) {
              map.put(input.charAt(i),map.getOrDefault(input.charAt(i),0)+1);
            }
            for (char ch : input.toCharArray()
            ) {
                if (map.containsKey(ch) && map.get(ch) == 1) {
                    unique= ch;
                    break;
                }
            }
            return unique;
        } else {
            throw new IllegalArgumentException("");
        }
    }

    /**
     * int doTestsPass()
     * Returns 1 if all tests pass. Otherwise returns 0.
     */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        String[] inputs = {"apple", "racecars", "ababdc","aaaaaaaaaarccccrm", "bbbbbbbb"};
        char[] outputs = {'a', 'e', 'd','m', ' '};

        boolean result = true;
        for (int i = 0; i < inputs.length; i++) {
            result = result && findFirst(inputs[i]) == outputs[i];
            if (!result) {
                System.out.println("Test failed for: " + inputs[i]);
            } else {
                System.out.println("Test passed for: " + inputs[i]);
            }
        }
        return (result);
    }

    public static void main(String args[]) {
        doTestsPass();
    }
}
