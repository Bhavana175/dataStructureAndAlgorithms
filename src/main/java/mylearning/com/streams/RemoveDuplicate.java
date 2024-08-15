package mylearning.com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicate {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 33, 44, 12, 1, 4, 33, 44, 20, 20);

        removeDuplicate(numbers);

    }

    private static void removeDuplicate(List<Integer> numbers) {

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctNumbers);
    }

}
