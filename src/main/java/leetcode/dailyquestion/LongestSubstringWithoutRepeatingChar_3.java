package leetcode.dailyquestion;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChar_3 {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(findLongestSubstringUniqueCharacter("abcabcdefghijkabc"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        HashSet<Character> uniqueCharSet = new HashSet<>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (!uniqueCharSet.add(ch)) {
                uniqueCharSet.remove(s.charAt(start));
                start++;
            }
            maxlen = Math.max(maxlen, i - start + 1);
        }

        return maxlen;
    }

    public static String findLongestSubstringUniqueCharacter(String s) {

        HashSet<Character> set = new HashSet<>();
        int startSub = 0, endSub = 0;
        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (!set.add(ch)) {
                set.remove(s.charAt(start));
                start++;
            }
            if (maxLen < i - start + 1) {
                maxLen = i - start + 1;
                startSub = start;
                endSub = i;
            }
        }


        return s.substring(startSub, endSub+1);
    }

}
