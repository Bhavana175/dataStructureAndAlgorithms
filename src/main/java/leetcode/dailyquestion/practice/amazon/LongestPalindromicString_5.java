package leetcode.dailyquestion.practice.amazon;

public class LongestPalindromicString_5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i - 1, r = i + 1;

            while (l >= 0 && r < s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                if (maxLen < r - l + 1) {
                    maxLen = r - l + 1;
                    start = l;
                    end = r;
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l <= r && r < s.length() - 1 && s.charAt(l) == s.charAt(r)) {
                if (maxLen < r - l + 1) {
                    maxLen = r - l + 1;
                    start = l;
                    end = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(start, end + 1);
    }
}
