package leetcode.dailyquestion;

import java.util.Stack;

public class RemoveAllOccurrencesOfSubstring1910 {

    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
    }

    public static String removeOccurrences(String s, String part) {

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = part.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == part.charAt(k)) {
                int pointer = k - 1;
                while (!stack.isEmpty() && pointer >= 0 && stack.peek() == part.charAt(pointer)) {
                    stack.pop();
                    pointer--;
                }
                if (pointer > 0) {
                    for (int j = pointer + 1; j < k; j++) {
                        stack.push(part.charAt(j));
                    }
                }
            } else
                stack.push(ch);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
