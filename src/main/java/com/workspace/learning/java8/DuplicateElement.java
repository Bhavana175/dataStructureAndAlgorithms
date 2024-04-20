package com.workspace.learning.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateElement {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 22, 33, 22, 5, 6, 4, 2, 4, 1, 20);

        //distinct
        List<Integer> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);

        //Duplicate

        HashSet<Integer> set = new HashSet<>();
        list.stream()
                .filter(num->!set.add(num))
                .forEach(System.out::println);

    }
}
