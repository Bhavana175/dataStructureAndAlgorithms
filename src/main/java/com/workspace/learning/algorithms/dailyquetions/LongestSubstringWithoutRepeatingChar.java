package com.workspace.learning.algorithms.dailyquetions;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {

        String s = "geeksforgeeks";

        System.out.println(longestSubstringUniqueChar(s));

    }

    private static String longestSubstringUniqueChar(String str) {

        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int maxLen = Integer.MIN_VALUE;
        int startIndex = 0;
        int start = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            sb.append(ch);

            if (set.add(ch)) {
                if (sb.length() > maxLen) {
                    maxLen = sb.length();
                    startIndex = start;
                }
            } else {
                while (!set.add(ch) && start < i) {
                    sb.deleteCharAt(0);
                    set.remove(str.charAt(start));
                    start++;
                }
            }
        }

        return str.substring(startIndex, startIndex + maxLen);
    }

}
