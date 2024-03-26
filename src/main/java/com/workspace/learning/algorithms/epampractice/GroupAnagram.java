package com.workspace.learning.algorithms.epampractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    /* Group Anagram
      Input: strs = ["eat","tea","tan","ate","nat","bat"]
      Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

      Input: strs = [""]
      Output: [[""]]

      Input: strs = ["a"]
      Output: [["a"]] */

    public static void main(String[] args) {

        String [] arr = {"eat","tea","tan","ate","nat","bat"};
        // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
        GroupAnagram obj = new GroupAnagram();

        List<List<String>> groupAnagram = obj.getGroupAnagram(arr);
        groupAnagram.forEach(System.out::println);

    }

    private List<List<String>> getGroupAnagram(String[] arr) {

        List<List<String>> anagramGroupList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        List<String> anagramList = new ArrayList<>();

        //key is the sorted value of string, add string in list

        for(int i=0; i< arr.length; i++){
          String sortedKey= arr[i];

          char[] chars= sortedKey.toCharArray();
          Arrays.sort(chars);
          sortedKey= new String(chars);

          if(map.containsKey(sortedKey)){
              anagramList = map.get(sortedKey);
          }else {
              anagramList=new ArrayList<>();
          }
            anagramList.add(arr[i]);
            map.put(sortedKey, anagramList);

        }

        map.values().forEach(val->anagramGroupList.add(val));

        return anagramGroupList;
    }

}
