package com.workspace.learning.interviews.epampractice;

import java.util.HashSet;

public class LongestUniqueSubstring {

    public static void main(String[] args) {

        String str = "abcdalkjnfi";

        String output = longestUniqueSubstring(str);
        System.out.println(output);

        String output1 = longestUniqueSubstring("aa");
        System.out.println(output1);

    }

    private static String longestUniqueSubstring(String str) {

        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < str.length(); i++) {

            if (set.add(str.charAt(i))) {

                maxLen = Math.max(maxLen, i - start + 1);

            } else {

                while (!set.add(str.charAt(i))) {
                    set.remove(str.charAt(start));
                    start++;
                }
            }
        }
        System.out.println(maxLen);
        return str.substring(start);
    }

}
