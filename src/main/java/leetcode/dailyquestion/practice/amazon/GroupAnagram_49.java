package leetcode.dailyquestion.practice.amazon;

import java.util.*;

public class GroupAnagram_49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String key = sortString(strs[i]);
            map.computeIfAbsent(key, (k) -> new ArrayList<>()).add(strs[i]);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private static String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return Arrays.toString(arr);
    }
}
