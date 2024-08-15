package mylearning.com.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CalculateSumEvenOdd {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,2);

        calSumOfEvenAndOddNumbers(list);

        //max value

        System.out.println("max number : "+list.stream().max(Integer::compareTo).orElse(null));
        System.out.println("min number : "+list.stream().min(Integer::compareTo).orElse(null));

    }

    private static void calSumOfEvenAndOddNumbers(List<Integer> numbers) {

        int sum = numbers.stream()
                .filter(num->num%2==0)
                .reduce(0,(a,b)->a+b);

        System.out.println("sum even :"+sum);

        int sumOfOdds = numbers.stream()
                .filter(num -> num % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("sum odd :"+sumOfOdds);
    }

}
