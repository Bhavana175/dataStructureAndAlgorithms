package leetcode.dailyquestion;

import java.util.HashSet;

public class LongestSubstringUniqueCharacter {
    public static void main(String[] args) {
        System.out.println(find("pwwkew"));
    }

    private static int find(String s) {

        int maxLen = 0;
        int start =0;
        int startIndex =0;
        int end =0;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(!set.add(ch)){
                while (!set.add(ch)){
                    set.remove(s.charAt(start));
                    start++;
                }
            }
            if(maxLen<i-start+1){
                maxLen = i-start+1;
                startIndex = start;
                end = i;
            }


        }
        System.out.println(s.substring(startIndex, end+1));
        return maxLen;
    }
}
