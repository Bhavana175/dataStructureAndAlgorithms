package leetcode.dailyquestion.dp.lcs;

public class MinimumNumberOfInsertionDeletion {
    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";

        System.out.println(findMinNumberOfInsertionDeletionRequired(s1, s2));
    }

    private static int findMinNumberOfInsertionDeletionRequired(String s1, String s2) {
        /*
                    heap             pea
                        \           /
                    2 deletion    1 Insertion
                            \    /
                            ea (lcs)

            total min req operation 3
         */
        int n = s1.length();
        int m = s2.length();
        int lcsLen = lcs(s1, s2, n, m);

        return (n - lcsLen) + (m - lcsLen);
    }

    public static int lcs(String s1, String s2, int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcs(s1, s2, n - 1, m - 1);
        } else return Math.max(lcs(s1, s2, n - 1, m), lcs(s1, s2, n, m - 1));

    }
}
