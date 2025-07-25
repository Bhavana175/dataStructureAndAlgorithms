package leetcode.dailyquestion.dp.lcs;

import java.util.Stack;

public class LongestCommonSubsequenceStrDP {
    public static void main(String[] args) {
        String x = "abcd";
        String y = "cefd";/*String x = "abcdefgh";
        String y = "abcdytegh";*/
        System.out.println(findLongestCommonSubsequence(x, y));
    }

    public static int findLongestCommonSubsequence(String x, String y) {
        int n = x.length();
        int m = y.length();
        int[][] t = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);

            }
        }
        StringBuilder sb = new StringBuilder();

        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                sb.append(x.charAt(i-1));
                i--;
                j--;
            }else if(t[i-1][j]>t[i][j-1]){
                i--;
            }else j--;
        }

        System.out.println(sb.reverse());
        return t[n][m];
    }
}