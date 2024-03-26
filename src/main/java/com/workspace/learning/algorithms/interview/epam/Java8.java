package com.workspace.learning.algorithms.interview.epam;

import java.util.Arrays;

public class Java8 {


    //Q1. given an array, nums = {10,20,30,10,12, 18}
    //find average of square of numbers >100


    public static void main(String[] args) {

        int [] nums = {10,20,30,10,12, 18};

        Double val =Arrays.stream(nums)
                .map(i->i*i)
                .filter(i->i>100)
                .average()
                .getAsDouble();

        System.out.println(val);


    }

}
