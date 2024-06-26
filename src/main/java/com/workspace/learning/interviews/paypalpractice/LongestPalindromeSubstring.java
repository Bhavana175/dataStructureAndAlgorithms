package com.workspace.learning.interviews.paypalpractice;

public class LongestPalindromeSubstring {
    //  https://leetcode.com/problems/longest-palindromic-substring/description/
    /*
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

     */

    public static void main(String[] args) {

        String input = "ccc";
        System.out.println("input :" + input);
        String output = findLongestPalindromeSubstr(input);
        System.out.println("output :" + output);

        //

    }

    private static String findLongestPalindromeSubstr(String str) {
        int maxLen = 0;
        int startIndex = 0;
        int lastIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            int l = i - 1, r = i + 1;
            //qeaooarttuj
            //for odd length palindrome
            while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
                if (maxLen < r - l + 1) {
                    maxLen = r-l+1;
                    startIndex = l;
                    lastIndex = r;
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
                if (maxLen < r - l + 1) {
                    maxLen = r-l+1;
                    startIndex = l;
                    lastIndex = r;
                }
                l--;
                r++;
            }

        }
        return str.substring(startIndex, lastIndex + 1);
    }

}
