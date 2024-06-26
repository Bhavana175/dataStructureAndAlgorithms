package com.workspace.learning.java8.cognizant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupBy {

    public static void main(String[] args) {

        System.out.println(" find the first non-repeated character in : JJava Xarticles are JAwesome");
        String input = "xyyzzaaabbc";

        String input1= input.toLowerCase().replaceAll("\\s","");

        System.out.println(input1+"  non repeated");
        input1.chars().map(c-> (char) c)
                .collect(
                        ()-> { return new HashMap<Character, Integer>();},
                        (map, ch)->{map.put((char)ch, map.getOrDefault((char)ch,0)+1);},
                        (map, a)->{map.putAll(a);}
                )
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .findFirst()
                .ifPresent(m-> System.out.println(m.getKey()));

        System.out.println(" Collectors group by ");

        input1.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        ()->{return new HashMap<>();},
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue()>1)
                .findFirst()
                .ifPresent(m-> System.out.println(m.getKey())); //Store the chars in map with count

        System.out.println("concatenate 2 streams ");
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concat = Stream.concat(list1.stream(), list2.stream());
        concat.forEach(System.out::println);

        System.out.println(" Write a Java 8 program to sort an array and then convert the sorted array into Stream?");

        int arr[] = { 99, 55, 203, 99, 4, 91 };

        Arrays.stream(arr).sorted().forEach(System.out::println);

        System.out.println("How to convert a List of objects into a Map by" +
                " considering duplicated keys and store them in sorted order?");

        List<Integer> list =Arrays.asList(99, 55, 203, 99, 4, 91 );

        Map<Integer, Long> collect = list.stream().collect(Collectors.groupingBy
                (Function.identity(), Collectors.counting()));

        collect.entrySet().stream().sorted((e1,e2)-> e1.getKey()-e2.getKey()).forEach(System.out::println);

    }
}
