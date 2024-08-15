package mylearning.com.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Code {

    public static void main(String[] args) {

        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 21, 71, 32, 67, 32, 95, 14, 56, 87);


        Integer max =listOfIntegers.stream()
                //.max(Comparator.comparingInt()).orElse(0);
                .max(Comparator.comparingInt(Integer::intValue)).orElse(0);
        System.out.println(max);

        /**
         * Separate odd and even numbers from a list
         */
        Java8Code obj = new Java8Code();
        obj.separateOddAndEven(listOfIntegers);
        obj.removeDuplicateElement(listOfIntegers);

        String inputString = "Bhavana Karde";
        obj.findFrequencyOfEachChar(inputString);

    }

    private void findFrequencyOfEachChar(String inputString) {
        Map<Character,Long> map =  inputString.chars()
                .mapToObj(c-> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.forEach((key, value) -> System.out.print(key + " = " + value+", "));

    }

    private void removeDuplicateElement(List<Integer> listOfIntegers) {
        System.out.println();
        listOfIntegers.stream().distinct().forEach(num-> System.out.print(num+" "));
    }

    private void separateOddAndEven(List<Integer> listOfIntegers) {

        List<Integer> evenNumList = listOfIntegers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> oddNumList = listOfIntegers.stream()
                .filter(num -> num % 2 == 1)
                .collect(Collectors.toList());

        evenNumList.stream().forEach(num-> System.out.print(num+" "));
        System.out.println();
        oddNumList.stream().forEach(num-> System.out.print(num+" "));
    }

}
