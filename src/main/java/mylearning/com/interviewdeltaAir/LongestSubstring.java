package mylearning.com.interviewdeltaAir;

import java.util.HashSet;

public class LongestSubstring {


/*    given a string
      s = "abcabcbb"
      output - abc
      s2= bbbbb
      output = b

      */
//Delta Air
    public static void main(String[] args) {

        LongestSubstring obj = new LongestSubstring();

        System.out.println("string : " + obj.getLongestSubstring("bbbbbb"));

    }

    public int getLongestSubstring(String str) {

        int maxLen = Integer.MIN_VALUE;
        int subLength = 1;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {

            if (!set.add(str.charAt(i))) {
                maxLen = Math.max(maxLen, subLength - 1);
                subLength = 0;
                set.clear();
            } else {
                subLength++;
            }
        }

        System.out.println("max len " + maxLen);
        return maxLen;
    }

}
