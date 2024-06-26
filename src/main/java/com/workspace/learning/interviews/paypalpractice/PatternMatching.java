package com.workspace.learning.interviews.paypalpractice;

//https://leetcode.com/problems/regular-expression-matching/
public class PatternMatching {

    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        boolean match = isMatch(s, p);
        System.out.println("str =      " + s);
        System.out.println("pattern =  " + p);
        System.out.println(match);

        String s1 = "mississippi";
        String p1 = "mis*is*p*.";

        boolean match1 = isMatch(s1, p1);
        System.out.println("str =      " + s1);
        System.out.println("pattern =  " + p1);
        System.out.println(match1);

    }

    /*
    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.
     */

    public static boolean isMatch(String s, String p) {
        boolean allowed = false;

        if (p.isEmpty() || s.isEmpty()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (i < p.length() && p.charAt(i) == '.') {
                allowed = true;
            } else if (i < p.length() && p.charAt(i) == '*') {
                int position = i - 1;
                while (position > 0 && i > 0 && i < s.length() && s.charAt(position) == s.charAt(i)) {
                    allowed = true;
                    i++;
                }

            } else if (i < p.length() && s.charAt(i) == p.charAt(i)) {
                allowed = true;

            } else {
                allowed = false;
            }

        }

        return allowed;
    }
}
