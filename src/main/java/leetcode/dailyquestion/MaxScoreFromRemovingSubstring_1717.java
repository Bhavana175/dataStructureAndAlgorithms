package leetcode.dailyquestion;

import java.util.Stack;

public class MaxScoreFromRemovingSubstring_1717 {

    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x = 4, y = 5;
        System.out.println(maximumGain(s, x, y));
    }

    public static int maximumGain(String s, int x, int y) {
        if (x > y) {
            return removeSubstring(s, x, y, 'a', 'b');
        } else {
            return removeSubstring(s, y, x, 'b', 'a');
        }
    }

    private static int removeSubstring(String s, int x, int y, char first, char second) {

        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == first && !stack.isEmpty() && stack.peek() == second) {
                sum += x;
                stack.pop();
            } else stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
      //  sb.reverse();
        stack.clear();
        for (int i = sb.toString().length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (ch == second && !stack.isEmpty() && stack.peek() == first) {
                sum += y;
                stack.pop();
            } else stack.push(ch);
        }

        return sum;
    }
}
