package com.workspace.learning.interviews.paypalpractice;

import java.util.HashSet;

public class UniqueBinary {

// Given a binary string, identify and print all unique two-digit binary numbers(Unique, Non Zero)
// that can be formed by scanning the string in a single direction.

// Example 1:
// Input: "001100011"
// Output: "01 11 10"

// Example 2:
// Input: "1111"
// Output: "11"

// Example 3:
// Input: "1100"
// Output: "11 10"

    public static void main(String[] args) {

        String input = "001100011";
        String output = findUniqueTwoDigitBinaryNum(input);
        System.out.println("input   " + input);
        System.out.println("output  " + output);

        String input1 = "1111";
        String output1 = findUniqueTwoDigitBinaryNum(input1);
        System.out.println("input   " + input1);
        System.out.println("output  " + output1);

        String input2 = "1100";
        String output2 = findUniqueTwoDigitBinaryNum(input2);
        System.out.println("input   " + input2);
        System.out.println("output  " + output2);

    }

    private static String findUniqueTwoDigitBinaryNum(String input) {

        HashSet<String> set = new HashSet<>();
        int len = input.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len - 1; i++) {

            String s = input.substring(i, i + 2);

            if (!"00".equals(s)) {

                if (set.add(s)) {
                    sb.append(s);
                }
            }
        }

        return sb.toString();

    }

}
