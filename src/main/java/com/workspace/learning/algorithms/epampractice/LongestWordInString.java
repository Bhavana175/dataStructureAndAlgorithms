package com.workspace.learning.algorithms.epampractice;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordInString {

    public static void main(String[] args) {


        String str = "I booked swimming class for today";

        System.out.println(Arrays.stream(str.split(" "))
                .max(Comparator.comparing(String::length)).get());

    }


}
