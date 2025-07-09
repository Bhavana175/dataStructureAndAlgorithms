package mylearning.com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyElement {

    public static void main(String[] args) {
        List<String> stationeryList = Arrays.asList("Pen", "Eraser",
                "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");


        Map<String, Long> collect = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((k,v)-> System.out.println(k+" "+v));
        System.out.println("---------");

        FrequencyElement obj = new FrequencyElement();
        obj.findFrequencyOfEachElement(stationeryList);

    }

    private void findFrequencyOfEachElement(List<String> stationeryList) {

        Map<String, Long> freqMap = stationeryList.stream()
                //.map(str->(String) str)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

      //  freqMap.forEach((K,V)-> System.out.println(K+" "+V+", "));

        System.out.println(freqMap);

    }

}
