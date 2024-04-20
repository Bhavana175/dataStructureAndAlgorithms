package com.workspace.learning.algorithms.dailyquetions;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

    //https://leetcode.com/problems/isomorphic-strings/description/?envType=daily-question&envId=2024-04-02
    public static void main(String[] args) {

        String s1 = "badc";
        String s2 = "baba";
        //given s1.length = s2.length
        Isomorphic obj = new Isomorphic();
        System.out.println("output : " + obj.isIsomorphic(s1, s2));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Boolean> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (!map.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            } else if (map2.containsKey(t.charAt(i))) {
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), true);
            }
        }

        return true;
    }

}
