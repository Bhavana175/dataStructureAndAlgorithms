package leetcode.dailyquestion.booking_practice;

import java.util.HashMap;

public class MinimumWindowSubString_76 {
    public static void main(String[] args) {
        String s = "aa", t = "aa";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";
        int start = 0;
        int end =0;
        int minWindow = s.length();

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // for s we have -1 freq
        int i = 0, j = 0;
        int count = t.length();
        while (j < s.length()) {

            char ch = s.charAt(j);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) - 1);

            if (freqMap.get(ch) >= 0) {
                count--;
            }

            while (count == 0) {
                if(minWindow>= j-i+1){
                    minWindow = j - i + 1;
                    start = i;
                    end = j+1;
                }
                freqMap.put(s.charAt(i), freqMap.get(s.charAt(i))+1);
                if(freqMap.get(s.charAt(i))>0){
                    count++;
                }
                i++;
            }
            j++;
        }
        return s.substring(start, end);
    }

}
