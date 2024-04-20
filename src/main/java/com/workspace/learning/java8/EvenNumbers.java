package com.workspace.learning.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 3, 2, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNum = list.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNum);

    }

}
