package mylearning.com.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ReverseList {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple ", "Banana ", "Mango ", "Strawberry ");
        List<String> list1 = Arrays.asList("100 ", "200 ", "400 ", "800 ");

        List<String> list2 = Arrays.asList("Red ", "Black ", "Orange ", "Pink ");
        reverseList(list);
        reverseList(list1);
        reverseList(list2);

    }
    private static void reverseList(List<String> list) {

        list.forEach(System.out::print);
        System.out.println();
        //first sort thn reverse
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println();
        Collections.reverse(list);
        list.forEach(System.out::print);
        System.out.println();
    }

}
