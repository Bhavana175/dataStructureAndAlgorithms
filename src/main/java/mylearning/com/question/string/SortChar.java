package mylearning.com.question.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortChar {

    /**
     * Given a string s, sort it in decreasing order based on the frequency of the characters.
     * The frequency of a character is the number of times it appears in the string.
     * <p>
     * Return the sorted string. If there are multiple answers, return any of them.
     * <p>
     * Example 1:
     * <p>
     * Input: s = "tree"
     * Output: "eert"
     * Explanation: 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     * Example 2:
     * <p>
     * Input: s = "cccaaa"
     * Output: "aaaccc"
     * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
     * Note that "cacaca" is incorrect, as the same characters must be together.
     * Example 3:
     * <p>
     * Input: s = "Aabb"
     * Output: "bbAa"
     * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
     * Note that 'A' and 'a' are treated as two different characters.
     */

    public static void main(String[] args) {

        SortChar obj = new SortChar();

        String str = "tttreerrerrr";
        System.out.println("input : " + str);
        System.out.println("output  : " + obj.frequencySort(str));

    }

    private String frequencySort(String str) {
        StringBuilder str2 = new StringBuilder();
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            hashMap.put(str.charAt(i), hashMap.getOrDefault(str.charAt(i), 0) + 1);
        }
        ArrayList<Map.Entry<Character, Integer>> mapEntryList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(mapEntryList, (o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<Character, Integer> entry : mapEntryList) {
            for (int i = 0; i < entry.getValue(); i++) {
                str2.append(entry.getKey());
            }
        }

        return str2.toString();
    }

}
