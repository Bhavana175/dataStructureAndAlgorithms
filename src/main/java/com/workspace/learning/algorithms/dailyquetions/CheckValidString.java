package com.workspace.learning.algorithms.dailyquetions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class CheckValidString {

    //https://leetcode.com/problems/valid-parenthesis-string/description/?envType=daily-question&envId=2024-04-07

    public static void main(String[] args) {

        String s ="(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
        // * can be  "" or ( or )
        //((*))  (*)))  (**))
        //output : true
        System.out.println(s);
        CheckValidString obj = new CheckValidString();
        System.out.println("output : "+obj.checkValidString(s));

    }

    public boolean checkValidString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(',0);
        map.put(')',0);
        map.put('*',0);
        for (char ch :s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        if(Objects.equals(map.get('('), map.get(')'))){
            return true;
        }else if(map.get('*')>= Math.abs(map.get('(')-map.get(')'))){
            return true;
        }
        return false;
    }

}
