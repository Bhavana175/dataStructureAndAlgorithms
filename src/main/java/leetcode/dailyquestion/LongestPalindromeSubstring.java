package leetcode.dailyquestion;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        String s = "anitin";
        System.out.println(findLongestPalindromeSubstring(s));
    }


    private static String findLongestPalindromeSubstring(String s) {
        int n = s.length();
        int maxlen = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {

            int l = i - 1;
            int r = i + 1;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (maxlen < r - l + 1) {
                    start = l;
                    end = r;
                    maxlen = r - l + 1;
                }
                l--;
                r++;
            }

             l = i;
             r = i + 1;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (maxlen < r - l + 1) {
                    start = l;
                    end = r;
                    maxlen = r - l + 1;
                }
                l--;
                r++;
            }
        }

        return s.substring(start, end+1);
    }
}
