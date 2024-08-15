package mylearning.com.question.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    /**
     * Given an array of strings strs, group the anagrams together.
     * You can return the answer in any order.
     * An Anagram is a word or phrase formed by rearranging
     * the letters of a different word or phrase, typically
     * using all the original letters exactly once.
     * <p>
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * <p>
     * Input: strs = [""]
     * Output: [[""]]
     * <p>
     * Input: strs = ["a"]
     * Output: [["a"]]
     */

    public static void main(String[] args) {

        GroupAnagram obj = new GroupAnagram();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> output = obj.groupAnagrams(strs);

        System.out.println("output : " + output.toString());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramGroupList = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            ArrayList<String> anagramList = new ArrayList<>();
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[i] != null ) {
                    if (strs[j] != null && checkForAnagram(strs[i], strs[j])) {
                        anagramList.add(strs[j]);
                        strs[j] = null;
                    }

                } else {
                    break;
                }

            }
            if (strs[i] != null) {
                anagramList.add(strs[i]);
                if (!anagramList.isEmpty()) {
                    anagramGroupList.add(count, anagramList);
                    count++;
                }
            }
        }

        return anagramGroupList;
    }

    private boolean checkForAnagram(String str1, String str2) {

        int[] arr = new int[26];
        int sum = 0;
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i) - 'a']++;
            arr[str2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            sum = sum + Math.abs(arr[i]);
        }
        return sum == 0;
    }

}
