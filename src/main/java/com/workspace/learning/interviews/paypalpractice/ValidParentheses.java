package com.workspace.learning.interviews.paypalpractice;

import java.util.Stack;

public class ValidParentheses {

    //https://leetcode.com/problems/valid-parentheses/description/

    public static void main(String[] args) {
        /*
        Input: s = "()"
        Output: true
         */
        String s = "(){}[]";
        boolean output = isValid(s);
        System.out.println("input  : " + s);
        System.out.println("output : " + output);

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else if( stack.isEmpty() &&( c==')' || c=='}' || c==']' )) return false;
            else{
                if (!stack.isEmpty() && c==')' && stack.pop()!='(') return false;
                if (!stack.isEmpty() && c=='}' && stack.pop()!='{') return false;
                if (!stack.isEmpty() && c==']' && stack.pop()!='[') return false;
            }
        }
        return stack.isEmpty();

    }

}
