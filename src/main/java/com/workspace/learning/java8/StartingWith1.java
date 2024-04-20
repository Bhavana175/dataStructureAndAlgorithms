package com.workspace.learning.java8;

import java.util.Arrays;
import java.util.List;

public class StartingWith1 {
//https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 1, 2, 13, 16, 8, 5, 1110, 89, 70);

        list.stream().map(num->num+"")
                .filter(str->str.startsWith("1"))
                .forEach(System.out::println);

    }

}
