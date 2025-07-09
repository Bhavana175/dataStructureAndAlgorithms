package mylearning.com.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagrams {
    /**
     * ava 8 program to check if two strings are anagrams or not?
     */

    public static void main(String[] args) {

        String s1 = "RaceCar";
        String s2 = "CarRace";

        Map<Character,Long> map1 = s1.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character,Long> map2 = s2.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println( map1.equals(map2));


        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for (char ch : s2.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)-1);
        }
        boolean flag = true;
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()!=0){
                flag = false;
                break;
            }
        }
        System.out.println(flag);


        //via stream

        Map<Character, Long> s1FreqMap = s1.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> s2FreqMap = s1.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(s1FreqMap.equals(s2FreqMap));
    }
}
