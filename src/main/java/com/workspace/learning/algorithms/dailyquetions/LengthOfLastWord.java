package com.workspace.learning.algorithms.dailyquetions;

import java.util.Arrays;

public class LengthOfLastWord {

    //https://leetcode.com/problems/length-of-last-word/?envType=daily-question&envId=2024-04-01
    public static void main(String[] args) {

        String s = "luffy is still joyboy";
       // Output: 6
       // Explanation: The last word is "joyboy" with length 6.

        System.out.println(
                Arrays.stream(s.split(" "))
                .filter(word -> !word.isEmpty())
                .reduce((first, second) -> second)
                .map(String::length)
                .orElse(0)
        );

    }

}
