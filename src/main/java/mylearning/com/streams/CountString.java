package mylearning.com.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CountString {

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("aman", "aaru", "paridhi", "pranky", "amir");
        countStringStartsWith(strs, "p");


        //sort list ascending
        strs.stream().sorted().forEach(System.out::println);
        System.out.println();
        //sort desc

        strs.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void countStringStartsWith(List<String> strs, String a) {

       long counter= strs.stream().filter(str -> str.startsWith(a)).count();
        System.out.println(counter);
    }

}
