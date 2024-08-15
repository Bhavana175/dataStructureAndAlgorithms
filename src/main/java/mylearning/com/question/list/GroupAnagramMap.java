package mylearning.com.question.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramMap {

    /**
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * * <p>
     * * Input: strs = [""]
     * * Output: [[""]]
     * * <p>
     * * Input: strs = ["a"]
     * * Output: [["a"]]
     */

    public static void main(String[] args) {

        GroupAnagramMap obj = new GroupAnagramMap();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("input : "+Arrays.asList(strs));
        List<List<String>> output = obj.groupAnagrams(strs);

        System.out.println("output : " + output);
    }

    private List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> group = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            List<String> anagramList = new ArrayList<>();
            String sortedKey = strs[i];
            char[] charArr = sortedKey.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);

            if (map.containsKey(key)) {
                anagramList = map.get(key);
            }
            anagramList.add(strs[i]);
            map.put(key, anagramList);

        }
        int i = 0;

        for (Map.Entry entry : map.entrySet()
        ) {
            group.add(i, (List<String>) entry.getValue());
            i++;
        }

        return group;
    }

}
