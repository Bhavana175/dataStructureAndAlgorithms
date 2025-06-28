package leetcode.dailyquestion.dp.lcs;

public class LongestPalindromeSequenceLCS {
    public static void main(String[] args) {
        String s1 = "agbcba";
        System.out.println(lengthOfLongestPalindrome(s1));
    }

    private static int lengthOfLongestPalindrome(String s1) {
        StringBuilder sb = new StringBuilder(s1);
        String s2 = String.valueOf(sb.reverse());

        /*
                             s1     a g b c b a
                 reverse(s1) =s2    a b c b g a
             lcs(s1,s2) palindrome  a b c b a

         */

        return lcs(s1, s2, s1.length(), s2.length());
    }

    private static int lcs(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcs(s1, s2, n - 1, m - 1);
        } else return Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));
    }
}
