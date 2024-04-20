package com.workspace.learning.datastructure.stacks.problems;

import java.util.Stack;

public class BalanceExpression {

    // check given string expression is valid or not parentheses
    // str="(A+B)*[{C-D}+E]"   output valid
    // str="(A+B)*]{C-D}+E"    output invalid

    public static void main(String[] args) {

        String str = "(A+B)*{C-D}+[E]";
        String str2 = "(A+B)*{C-D}+E]";
        //output valid
        BalanceExpression obj = new BalanceExpression();
        System.out.println("input : " + str);
        System.out.println("output : " + obj.checkExpression(str));

        System.out.println("input : " + str2);
        System.out.println("output : " + obj.checkExpression(str2));

    }
    public boolean checkExpression(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (!stack.isEmpty()) {
                    char ch2 = stack.pop();
                    if (!((ch2 == '(' && ch == ')') ||
                            (ch2 == '[' && ch == ']') ||
                            (ch2 == '{' && ch == '}'))) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
