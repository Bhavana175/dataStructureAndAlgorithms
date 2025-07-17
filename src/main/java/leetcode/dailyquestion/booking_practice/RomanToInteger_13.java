package leetcode.dailyquestion.booking_practice;

import java.util.HashMap;

public class RomanToInteger_13 {
    public static void main(String[] args) {
        String s = "III";
        /*
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
         */
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {

        HashMap<Character, Integer> romanToInteger = new HashMap<>();
        romanToInteger.put('I',1);
        romanToInteger.put('V',5);
        romanToInteger.put('X',10);
        romanToInteger.put('L',50);
        romanToInteger.put('C',100);
        romanToInteger.put('D',500);
        romanToInteger.put('M',1000);
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(i+1<s.length() && romanToInteger.get(ch) < romanToInteger.get(s.charAt(i+1))){
                num -=romanToInteger.get(ch);
            }else num += romanToInteger.get(ch);
        }

        return num;
    }
}
