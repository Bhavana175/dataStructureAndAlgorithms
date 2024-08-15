package com.workspace.learning.algorithms.string;

import java.util.HashSet;

public class CustomSort {
    /*
    https://leetcode.com/problems/custom-sort-string/
     */

    public static void main(String[] args) {
        System.out.println(customSortString("fuwos", "abcfwsooffu"));

    }

    public static String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int[] ca = new int[26];
        HashSet<Character> orderSet = new HashSet<>();

        for (int i = 0; i < order.length(); i++) {
            orderSet.add(order.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {

            if (!orderSet.contains(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                ca[s.charAt(i) - 'a']++;
            }

        }

        for (int i = 0; i < order.length(); i++) {
            int count = ca[order.charAt(i) - 'a'];
            while (count > 0) {

                sb.append(order.charAt(i));
                count--;

            }

        }

        return sb.toString();
    }

}
