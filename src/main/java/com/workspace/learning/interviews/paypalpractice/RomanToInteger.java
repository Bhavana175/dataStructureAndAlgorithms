package com.workspace.learning.interviews.paypalpractice;

import java.util.HashMap;

public class RomanToInteger {

//https://leetcode.com/problems/roman-to-integer/description/

    public static void main(String[] args) {

        String s = "MCMXCIV";
        int output = romanToInt(s);
        System.out.println(output);

    }

    public static int romanToInt(String s) {
        int sum =0;
        HashMap<Character, Integer> map = initializeHashMapForIntegerValues();
        /*
         Input: s = "MCMXCIV"
         Output: 1994
         */
        for (int i = 0; i < s.length(); i++) {
            if(i < s.length()-1 && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                sum -=map.get(s.charAt(i));
            }else {
                sum +=map.get(s.charAt(i));
            }
        }
        return sum;
    }

    private static HashMap<Character, Integer> initializeHashMapForIntegerValues() {

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return map;
    }
}
