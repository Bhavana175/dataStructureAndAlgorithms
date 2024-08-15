package mylearning.com.question.string;

import java.util.HashSet;

public class BuddyString {

/*    Given two strings s and goal, return true if you can swap
      two letters in s so the result is equal to goal, otherwise, return false.
      Swapping letters is defined as taking two indices i and j
      (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
      For example, swapping at indices 0 and 2 in "abcd" results in "cbad".*/

    public static void main(String[] args) {

        BuddyString obj = new BuddyString();
        System.out.println("Buddy string   :" + obj.buddyStrings("abcd", "cbad"));
    }

    public boolean buddyStrings(String s, String goal) {

        // return false if length is not equal
        if (s.length() != goal.length()) {
            return false;
        }
        int[] freqArr = new int[26];
        for (int i = 0; i < goal.length(); i++) {
            freqArr[goal.charAt(i) - 'a']++;
            freqArr[s.charAt(i) - 'a']--;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum = sum + Math.abs(freqArr[i]);
        }

        if (s.equals(goal)) {
            HashSet<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (!set.add(c)) {
                    return true;
                }
            }
            return false;
        }
        int counter = 0;
        if (sum == 0) {

            for (int i = 0; i < goal.length(); i++) {

                if (goal.charAt(i) != s.charAt(i)) {
                    counter++;
                }

            }

        }
        return counter == 2;
    }

}
