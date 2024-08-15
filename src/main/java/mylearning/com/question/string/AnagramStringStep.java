package mylearning.com.question.string;


import java.util.HashMap;
import java.util.Map;

public class AnagramStringStep {

    /*    You are given two strings of the same length s and t. In one step you
        can choose any character of t and replace it with another character.
        Return the minimum number of steps to make t an anagram of s.
        An Anagram of a string is a string that contains the same characters
        with a different (or the same) ordering.
        Example 1:
        Input: s = "bab", t = "aba"
        Output: 1
        Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.*/
    public static void main(String[] args) {

        AnagramStringStep obj = new AnagramStringStep();
        System.out.println("steps required for leetcode and practice to be anagram : "+obj.minSteps("leetcode", "practice"));
    }

    public int minSteps(String s, String t) {
        int steps = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()
        ) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }

        }

        for (char ch1 : t.toCharArray()
        ) {
            if (map.containsKey(ch1)) {
                map.put(ch1, map.get(ch1) - 1);
            }
        }

        for (Map.Entry<Character, Integer> myMap : map.entrySet()
        ) {

            if (myMap.getValue() > 0) {
                steps = steps + myMap.getValue();
            }
        }

        return steps;

    }

}
