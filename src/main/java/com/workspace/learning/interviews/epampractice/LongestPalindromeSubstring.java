package com.workspace.learning.interviews.epampractice;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {

        String str = "aermadama";
        String output = longestSubstringPalindrome(str);
        System.out.println(output);

    }

    private static String longestSubstringPalindrome(String str) {
        int startIndex =0;
        int endIndex = 0;
        int maxLen = 0;

        for (int i = 0; i < str.length(); i++) {
            //odd len
            int l= i-1, r=i+1;

            while (0<=l && r<str.length() && str.charAt(l)==str.charAt(r)){

                if(maxLen<r-l+1){
                    maxLen= r-l+1;
                    startIndex=l;
                    endIndex = r;
                }
                l--;
                r++;

            }
            //for even length
            l= i; r=i+1;
            while (0<=l && r<str.length() && str.charAt(l)==str.charAt(r)){

                if(maxLen<r-l+1){
                    maxLen= r-l+1;
                    startIndex=l;
                    endIndex = r;
                }
                l--;
                r++;

            }
        }
        return str.substring(startIndex, endIndex+1);
    }

}
