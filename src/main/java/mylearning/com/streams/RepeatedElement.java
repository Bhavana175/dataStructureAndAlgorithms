package mylearning.com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import java.util.stream.Collectors;

public class RepeatedElement {

    public static void main(String[] args) {

        //Most repeated element
        List<String> list = Arrays.asList("Pen", "Pencil", "NoteBook", "Pen", "Pen");

        Map<String, Long> freqMap = list.stream()
                .collect(
                        Collectors.groupingBy
                                (Function.identity(), Collectors.counting()));

        Map.Entry<String, Long> max = freqMap
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get();

        System.out.println("key : "+max.getKey());
        System.out.println("value : "+max.getValue());
    }


}
