package com.workspace.learning.algorithms.epampractice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacter {


       /*
      Given a string s, find the length of the longest
      substring without repeating characters.

      Input: s = "abcabcbb"
      Output: 3

      Input: s = "bbbbb"
      Output: 1

      Input: s = "pwwkew"
      Output: 3
     */

    public static void main(String[] args) {

        LongestSubStringWithoutRepeatingCharacter obj = new LongestSubStringWithoutRepeatingCharacter();

        String str= "abcabcbb";
        System.out.println("output : "+obj.getLengthSubString(str));

    }

    private int getLengthSubString(String str) {
        int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> map= new HashMap<>();
        for(int i=0, start=0; i<str.length(); i++){

            if(map.containsKey(str.charAt(i))){
                maxLen= Math.max(maxLen, i-start);

                while (map.containsKey(str.charAt(i))){
                    map.remove(str.charAt(start));
                    start++;
                }

            }
            map.put(str.charAt(i), 1);

        }


        return maxLen;

    }

}
