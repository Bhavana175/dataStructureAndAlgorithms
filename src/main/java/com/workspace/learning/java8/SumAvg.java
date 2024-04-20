package com.workspace.learning.java8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class SumAvg {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 3, 4, 5, 2, 6, 7, 1);

        int sum = list.stream().filter(num->num%2==0).mapToInt(Integer::intValue).sum();

        double v = list.stream().filter(num->num%2==0).mapToDouble(Integer::doubleValue)
                .average().orElseGet(() -> 0.0);

        System.out.println(sum);

        System.out.println(v);
    }

}
