package leetcode.dailyquestion;

import java.util.HashMap;


public class RansomNote383 {
    public static void main(String[] args) {


    }

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) return false;

        HashMap<Character, Integer> magazineCharMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            magazineCharMap.put(ch, magazineCharMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (magazineCharMap.containsKey(ch)) {
                int freq = magazineCharMap.get(ch);
                if (freq >= 1) {
                    magazineCharMap.put(ch, freq - 1);
                } else return false;
            } else return false;
        }
        return true;
    }
}
