package mylearning.com.streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagrams {
    /**
     * ava 8 program to check if two strings are anagrams or not?
     */

    public static void main(String[] args) {

        String s1 = "RaceCar";
        String s2 = "CarRacB";

        Map<Character,Long> map1 = s1.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character,Long> map2 = s2.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println( map1.equals(map2));
    }
}
