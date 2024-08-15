package mylearning.com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperCase {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Bhavana", "Sneh", "Poonam", "Rahul", "Paridhi");

        convertToUppercase(list);
    }

    private static void convertToUppercase(List<String> list) {

        //  list.forEach(str->System.out.println(str.toUpperCase()));

        List<String> uppercaseStrings = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(uppercaseStrings);

        List<String> lowercaseStrings =list.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        System.out.println(lowercaseStrings);

    }

}
