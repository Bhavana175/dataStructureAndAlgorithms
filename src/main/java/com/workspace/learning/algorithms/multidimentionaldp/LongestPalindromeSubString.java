package com.workspace.learning.algorithms.multidimentionaldp;

public class LongestPalindromeSubString {

    /**
     * https://leetcode.com/problems/longest-palindromic-substring/?envType=study-plan-v2&envId=top-interview-150
     *
     * @param args
     */
    public static void main(String[] args) {

        LongestPalindromeSubString obj = new LongestPalindromeSubString();
        System.out.println("output " + obj.longestPalindrome("bb"));

    }

    public String longestPalindrome(String s) {

        //check if given string is palindrome or not (new function) , int maxLen
        //if yes -> return
        //if no ->

        int max = 0;
        String subStr = "";
        if(s.length()==1){
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                if (checkForPalindrome(str)) {
                    if (max < str.length()) {
                        subStr = str;
                    }
                    max = Math.max(max, str.length());
                }
            }
        }

        return subStr;
    }

    private boolean checkForPalindrome(String s) {
        boolean flag = true;
        for (int i = 0; i < s.length() / 2; i++) {

            if (!(s.charAt(i) == s.charAt(s.length() - i - 1))) {
                flag = false;
                break;
            }

        }
        return flag;
    }

}
