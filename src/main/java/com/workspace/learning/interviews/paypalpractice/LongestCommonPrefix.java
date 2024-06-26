package com.workspace.learning.interviews.paypalpractice;

import org.hibernate.result.Output;

public class LongestCommonPrefix {

    //https://leetcode.com/problems/longest-common-prefix/description/
/*
        Input: strs = ["flower","flow","flight"]
        Output: "fl"
 */
    public static void main(String[] args) {

        String[] input = {"flower", "flow", "flight"};
        String output = findLongestCommonPrefixStringArr(input);
        System.out.println(output);
    }

    private static String findLongestCommonPrefixStringArr(String[] arr) {

        if (arr.length == 0) {
            return "";
        }
        int endPointer = arr[0].length();
        String prefix = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {

            while (arr[i + 1].indexOf(prefix) !=0) {
                endPointer--;
                prefix = prefix.substring(0, endPointer);
            }

        }

        return prefix;
    }

}
