package com.workspace.learning.interviews.goldS.practice.two;

import java.util.Arrays;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "aabbbbbccddb";
        int[] output = lengthOfLongestSubstring(s);
        System.out.println(Arrays.toString(output));
        String s1 = "aabbb22rrrrr345571111111";
        int[] output1 = lengthOfLongestSubstring(s1);
        System.out.println(Arrays.toString(output1));
    }

    private static int[] lengthOfLongestSubstring(String s) {
        int startIndex = 0;
        int maxLength = 0;

        if (s.length() != 0) {
            for (int i = 0; i < s.length() - 1; i++) {
                int count = 1;
                int start = i;
                while (i < s.length() - 1 && (s.charAt(i) == s.charAt(i + 1))) {
                    count++;
                    i++;
                }
                if (count > maxLength) {
                    maxLength = count;
                    startIndex = start;
                }

            }

        }

        return new int[]{startIndex, maxLength};
    }

}
