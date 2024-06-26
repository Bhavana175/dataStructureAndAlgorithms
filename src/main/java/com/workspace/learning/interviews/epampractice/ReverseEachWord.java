package com.workspace.learning.interviews.epampractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseEachWord {

    public static void main(String[] args) {

        String str = "I love to code and problem solving";

        String output = reverseEachWord(str);
        //
        System.out.println(str);
        System.out.println(output);

        String s = Arrays.stream(str.split(" "))
                .map((word) -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(s);

    }

    private static String reverseEachWord(String str) {

        StringBuilder sb = new StringBuilder();
        String [] arr = str.split(" ");

        for (int i = 0; i < arr.length; i++) {
            char[] chars = arr[i].toCharArray();
            for (int j = chars.length-1; j >= 0; j--) {
                sb.append(chars[j]);
            }
            sb.append(" ");
        }

        return sb.toString();
    }

}
