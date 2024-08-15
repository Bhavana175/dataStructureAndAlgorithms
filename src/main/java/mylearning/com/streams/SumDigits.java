package mylearning.com.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumDigits {

    public static void main(String[] args) {
        /**
         * find second-largest number
         */
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        int j =listOfIntegers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce((a,b)->b)
                .orElse(0);

        List<Integer> listSorted = listOfIntegers.stream()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(listSorted);

        Integer thirdLargest =  listOfIntegers.stream()
                .sorted(Comparator.reverseOrder()).skip(2).findFirst().orElse(0);

        System.out.println(j);
        System.out.println(thirdLargest);

        //sum of digit
        int i = 15623;

        Integer sum = Stream.of(String.valueOf(i).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println(sum);




    }

}
