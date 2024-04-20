package com.workspace.learning.algorithms.dailyquetions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    //https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

    public static void main(String[] args) {
        String s = "ccaabbaab";
        int k = 3;
        LongestSubstring obj = new LongestSubstring();
        System.out.println( "output : "+obj.longestSubstring(s,k));
        // output : 7

    }

    public int longestSubstring(String s, int k) {
        int subLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, start = 0; i < s.length(); i++) {

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            while (map.get(s.charAt(i))> k) {

                map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) - 1);
                start++;
                subLen = Math.max(subLen, i - start + 1);

            }

        }
        return subLen;
    }

}
