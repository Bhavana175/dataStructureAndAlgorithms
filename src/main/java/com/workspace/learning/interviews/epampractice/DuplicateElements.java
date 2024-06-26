package com.workspace.learning.interviews.epampractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateElements {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list1 = list.stream().filter((num) -> !set.add(num)).toList();
        System.out.println("duplicate "+list1);


        // Create a map to count occurrences of each number
        Map<Integer, Long> countMap = list.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Filter and collect the duplicates including their repeated occurrences
        List<Integer> duplicates = list.stream().sorted()
                .filter(num -> countMap.get(num) > 1)
                .toList();

        // Print the duplicates
        System.out.println("Duplicates: " + duplicates);
    }

}
