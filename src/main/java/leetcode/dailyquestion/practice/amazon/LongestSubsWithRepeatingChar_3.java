package leetcode.dailyquestion.practice.amazon;

import java.util.HashSet;

public class LongestSubsWithRepeatingChar_3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int start = 0, i = 0;
        int maxLen =0;
        while (i<s.length()){
            char ch = s.charAt(i);
            while (!set.add(ch)){
                set.remove(s.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen, i-start+1);
            i++;
        }
        return maxLen;
    }
}
