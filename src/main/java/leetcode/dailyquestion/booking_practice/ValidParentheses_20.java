package leetcode.dailyquestion.booking_practice;

import java.util.Stack;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        String s = "()[]}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() &&
                        ( (stack.peek() == '{' && ch == '}')
                        || (stack.peek() == '[' && ch == ']')
                        || (stack.peek() == '(' && ch == ')'))) {
                    stack.pop();
                }else return false;
            }
        }

        return stack.isEmpty();
    }

}
