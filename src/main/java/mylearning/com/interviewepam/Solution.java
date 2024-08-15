package mylearning.com.interviewepam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String [] words = {"eat","tea","elbow","ate","below","bat"};
        List<List<String>> output = groupAnagrams(words);
        System.out.println(output);

        //Input:  ["eat","tea","elbow","ate","below","bat"]
        //Output: [["bat"],["below","elbow"],["ate","eat","tea"]]
    }
    private static List<List<String>> groupAnagrams(String[] words) {

        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> outputList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {

            String sortedKey = sortString(words[i]);
            List<String> list = new ArrayList<>();

            if(map.containsKey(sortedKey)){
                list= map.get(sortedKey);
            }
            list.add(words[i]);
            map.put(sortedKey,list);
        }
        map.forEach((k,v)-> outputList.add(v));
        return outputList;
    }

    private static String sortString(String str) {
        char [] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
