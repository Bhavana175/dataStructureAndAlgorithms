package com.workspace.learning.algorithms.string;

public class Solution {

    /**
     * 1. Epam Director Round:
     * <p>
     * Given a string s consisting of only the characters 'a' and 'b',
     * return true if every 'a' appears before every 'b' in the string.
     * Otherwise, return false.
     * Example 1: Input: s = "aaabbb"
     * Output: true
     * Explanation:The 'a's are at indices 0, 1, and 2,
     * while the 'b's are at indices 3, 4, and 5. Hence, every 'a'
     * appears before every 'b' and we return true.
     * Example 2:
     * Input: s = "abab" Output: false
     * Explanation:There is an 'a' at index 2
     * and a 'b' at index 1. Hence, not every 'a' appears before every 'b' and
     * we return false.
     * Example 3: Input: s = "bbb"Output: true
     * Explanation:There are no 'a's, hence, every 'a' appears before every 'b' and we return true.
     */

    public static void main(String[] args) {

        String str = "aaabbb";
        String str2 = "abab";
        String str3 = "bbbb";

        Solution solution = new Solution();
        System.out.println(solution.isABeforeB(str));
        System.out.println(solution.isABeforeB(str2));
        System.out.println(solution.isABeforeB(str3));

    }

    private boolean isABeforeB(String str) {
      /*  int lastIndexOfA = 0;
        int firstIndexOfB = str.length();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                lastIndexOfA = i;
            }
            if (str.charAt(i) == 'b') {
                if (firstIndexOfB > i) {
                    firstIndexOfB = i;
                }
            }
        }

        if (lastIndexOfA > firstIndexOfB) {
            return false;
        }
        return true;
*/
        boolean foundB = false;
        for (char c : str.toCharArray()) {
            if (c == 'b' && !foundB) {
                foundB = true;
            } else if (c == 'a' && foundB) {
                return false;
            }
        }

        return true;
    }

}
