package com.workspace.learning.interviews.paypalpractice;

import org.hibernate.result.Output;
import org.springframework.data.domain.Example;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChar {
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

/*    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.*/

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("input " + input);
        int output = findLongestSubstring(input);
        System.out.println("output " + output);

        String input1 = "bbbbbbb";
        System.out.println("input " + input1);
        int output1 = findLongestSubstring(input1);
        System.out.println("output " + output1);
    }

    private static int findLongestSubstring(String str) {
        int maxLen = 0;

        String subStr = "";
        HashSet<Character> set = new HashSet<>();

        int startIndex = 0;
        for (int i = 0; i < str.length(); i++) {

            if (set.contains(str.charAt(i))) {
                //remove from startIndex till duplicate is removed
                while (set.contains(str.charAt(i))) {
                    set.remove(str.charAt(startIndex));
                    startIndex++;
                }
            }
            set.add(str.charAt(i));
            if (maxLen < i - startIndex + 1) {
                subStr = str.substring(startIndex, i + 1);
            }
            maxLen = Math.max(maxLen, i - startIndex + 1);

        }
        System.out.println("sub : " + subStr);
        return maxLen;
    }

}
