package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinimumLength {

    //https://leetcode.com/problems/minimum-length-of-string-after-operations/?envType=daily-question&envId=2025-01-13
    public static void main(String[] args) {

        String s = "abaacbcbb";

        System.out.println(minimumLength(s));
        System.out.println(minimumLength2(s));
        System.out.println(minimumLength3(s));
    }

    public static int minimumLength2(String s) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                count += 2;
            } else count++;
        }

        return count;
    }

    //faster approach
    public static int minimumLength3(String s) {
        int count = 0;
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            if (arr[i] % 2 == 0) {
                count += 2;
            } else count++;
        }

        return count;
    }

    public static int minimumLength(String s) {

        int len = s.length();
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            ArrayList<Integer> list = map.put(ch, map.computeIfAbsent(ch, k -> new ArrayList<>()));
            list.add(i);
        }

        for (Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            while (size >= 3) {
                size = size - 2;
                len = len - 2;
            }
        }

        return len;
    }
}
