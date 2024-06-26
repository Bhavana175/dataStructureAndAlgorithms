package com.workspace.learning.interviews.epampractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {

    public static void main(String[] args) {

        List<String> anagrams = Arrays.asList("eat","god","dog","ate","pen","ola","lao","hello");
        List<List<String>> groupAnagram = groupAnagram(anagrams);

        System.out.println(groupAnagram);

    }

    private static List<List<String>> groupAnagram(List<String> anagrams) {
        List<List<String>> group = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < anagrams.size(); i++) {

            String sortedKey = sortString(anagrams.get(i));
            List<String> listOfAnagrams = map.computeIfAbsent(sortedKey, (k) -> new ArrayList<>());
            listOfAnagrams.add(anagrams.get(i));

        }

        map.forEach((k,v)->{
            group.add(v);
        });
        return group;
    }

    private static String sortString(String s) {
         char [] chars = s.toCharArray();
         Arrays.sort(chars);
         return Arrays.toString(chars);
    }

    //time : O(n* m log(m)) sorting time complexity: m log(m)
    //space O(n*l)  l= avg length of string

}
