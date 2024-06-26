package com.workspace.learning.algorithms.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Solution {

    //Find the longest Word in a given String/sentence using Java 8 features. Should not use manual loops.

    public static void main(String[] args) {
        String test = "Welcomeoooooooooooo to the EPAM Interview process";
        String longestWord="";

        longestWord = Arrays.stream(test.split(" "))
                .max(Comparator.comparing(String::length))
                .get();
        System.out.println(longestWord);

        System.out.println("longest new ************");
        Stream.of(test.split(" ")).max((a,b)->a.length()-b.length()).ifPresent(System.out::println);
        System.out.println("******");


        Solution obj = new Solution();
        obj.test(new Object());
        //main.test(null);

    }



    public void test(Object student) throws RuntimeException {
        //Refactor the below code following the Java 8 coding standards
/*        if (student == null) {
            throw new RuntimeException();
        } else {
            callStudentDetails(student);
        }*/

        Optional.of(student)
                .ifPresentOrElse(this::callStudentDetails, ()->{
                    throw new RuntimeException();
                });
    }

    //no modification required
    private void callStudentDetails (Object student) {
        //business logic
        System.out.println("call student method is called");
    }
}
