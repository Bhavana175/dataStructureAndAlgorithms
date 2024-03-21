package com.workspace.learning.algorithms.slidingwindow;

import java.util.HashSet;

public class LongestSubString {

    /**
     * Given a string s, find the length of the longest
     * substring without repeating characters.
     * <p>
     * Input: s = "abcabcbb"
     * Output: 3
     * <p>
     * Input: s = "bbbbb"
     * Output: 1
     * <p>
     * Input: s = "pwwkew"
     * Output: 3
     */

    public static void main(String[] args) {
        String s = "pwwkew";
        LongestSubString longestSubString = new LongestSubString();
        System.out.println(longestSubString.lengthOfLongestSubstring(s));

    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int len = s.length();

        HashSet<Character> hashSet = new HashSet<>();

        for (int i = 0, start = 0; i < len; i++) {

            if (!hashSet.contains(s.charAt(i))) {
                hashSet.add(s.charAt(i));
                max = Math.max(max, i - start + 1);

            } else {

                while (hashSet.contains(s.charAt(i))) {
                    hashSet.remove(s.charAt(start));
                    start++;

                }
                hashSet.add(s.charAt(i));
            }

        }

        return max;
    }
}
