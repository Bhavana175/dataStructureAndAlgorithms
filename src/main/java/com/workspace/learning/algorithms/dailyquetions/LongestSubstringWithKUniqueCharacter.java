package com.workspace.learning.algorithms.dailyquetions;

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacter {

    /*
    https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
     */
    public static void main(String[] args) {

        String str = "aabbcc";
        int k = 3;
        String str2 = "aabbcc";
        int k2 = 2;
        System.out.println(getFirstLongestSubstring(str, k));
        System.out.println(getFirstLongestSubstring(str2, k2));
        System.out.println(getFirstLongestSubstring(str2, 1));
        System.out.println(getFirstLongestSubstring("abcadcacacaca", 3));
        System.out.println(getFirstLongestSubstring("abcadcacacacabb", 2));

    }

    public static String getFirstLongestSubstring(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        String outputString = "";
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            sb.append(ch);

            if (map.size() <= k) {
                if (sb.length() > maxLen) {
                    maxLen = sb.length();
                    outputString = sb.toString();
                }
            } else {
                while (map.size() > k && start < i) {

                    char removeCh = s.charAt(start);
                    int count = map.get(removeCh);

                    sb.deleteCharAt(0);
                    map.put(removeCh, map.get(removeCh) - 1);

                    count--;
                    start++;

                    if (count == 0) {
                        map.remove(removeCh);
                    }

                }

            }

        }

        return outputString;
    }
}
