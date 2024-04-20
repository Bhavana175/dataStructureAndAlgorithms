package com.workspace.learning.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class FindMax {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 4, 5, 22, 55, 66, 1086, 177, 2000000);

        Integer max = list.stream()
                .max((a, b) -> a - b).get();
        System.out.println(max);

    }

}
