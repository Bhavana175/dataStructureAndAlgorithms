package leetcode.dailyquestion.dp.lcs;

public class ShortestCommonSuperSequencePrintLCS {
    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "cefd";/*
        String s1 = "gemek";
        String s2 = "erkse";*/

        System.out.println(shortestCommonSuperSequence(s1, s2));

    }

    private static String shortestCommonSuperSequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] t = new int[n + 1][m + 1];

        //base cond n==0 m==0 t[i][j] =0

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (t[i - 1][j] > t[i][j - 1]) {
                sb.append(s1.charAt(i - 1));
                i--;
            } else {
                sb.append(s2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(s1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(s2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();

    }

}
