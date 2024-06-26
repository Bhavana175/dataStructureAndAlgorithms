package com.workspace.learning.java8.cognizant;

import jakarta.persistence.criteria.CriteriaBuilder;

import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleQuetions {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,11,2,88,40,75,2,40,64);

        list.stream().filter(num -> num % 2 == 0).forEach(e-> System.out.println(e));

        list.stream().map(num->num+"").filter(str-> str.charAt(0)=='1').forEach(System.out::println);
        list.stream().map(num->num+"").filter(str-> str.startsWith("1")).forEach(System.out::println);
        System.out.println();
        HashSet<Integer> mySet = new HashSet<>();
        list.stream().filter(n-> !mySet.add(n)).forEach(System.out::println);

        List<String> stringList = Arrays.asList("bhavana", "ram", "syam", "mohan", "ram","bhavana", "ram");
        HashSet<String> set = new HashSet<>();
        stringList.stream().filter(s-> !set.add(s)).forEach(System.out::println);

        String str= "my name name    is bhavana";
        //find duplicate character
        String onlyCharStr = str.replaceAll("\\s","");
        HashSet<Character> charSet = new HashSet<>();
        onlyCharStr.chars().mapToObj(myCh-> (char)myCh)
                .filter(c -> !charSet.add(c))
                .distinct()
                .forEach(System.out::println);

        String str2= "Hello I am     am from     india india";
        HashSet<String> strSet = new HashSet<>();

        String str3 =str2.replaceAll("\\s+", " ");
        Stream.of(str3.split(" ")).filter(s->!strSet.add(s)).forEach(System.out::println);

        long count = list.stream().count();
        System.out.println(count);

        System.out.println("new ");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        Integer max = myList.stream().max((a, b) -> a - b).orElse(0);
        System.out.println(max);

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

        System.out.println("group by ");

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



    }

}
