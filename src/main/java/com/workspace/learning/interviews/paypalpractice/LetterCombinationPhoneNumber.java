package com.workspace.learning.interviews.paypalpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationPhoneNumber {

    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

    /*
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */

    public static void main(String[] args) {

        String input = "234";
        System.out.println("input : " + input);
        List<String> output = letterCombinations(input);
        System.out.println("output ");
        output.forEach(System.out::println);
        String input1 = "2";
        System.out.println("input : " + input1);
        List<String> output1 = letterCombinations(input1);
        System.out.println("output ");
        output1.forEach(System.out::println);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> letter = new ArrayList<>();
        if (digits.isEmpty()) {
            return letter;
        }

        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<Character> l1 = map.get(digits.charAt(0));
        for (char c : l1
        ) {
            letter.add(String.valueOf(c));
        }
        List<String> response = new ArrayList<>(letter);
        for (int i = 1; i < digits.length(); i++) {
            int j = 0;
            List<Character> l2 = map.get(digits.charAt(i));
            letter.clear();
            while (j < response.size()) {

                int k = 0;
                while (k < l2.size()) {

                    letter.add(response.get(j) + "" + l2.get(k));
                    k++;
                }
                j++;
            }
            response.clear();
            response.addAll(letter);

        }
        return response;
    }
}
