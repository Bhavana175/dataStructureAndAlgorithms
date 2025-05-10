package leetcode.dailyquestion;

import java.util.Stack;

public class LongestValidParentheses32 {

    public static void main(String[] args) {

        System.out.println(new LongestValidParentheses32().longestValidParentheses(")()())()()()()"));
    }

    public int longestValidParentheses(String s) {

        int maxLen = 0;
        Stack<Integer> stack = new Stack<>(); // index
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxLen = Math.max(maxLen, i-stack.peek());
                }
            }

        }
        return maxLen;
    }

}
