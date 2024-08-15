package mylearning.com.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseEachWordStr {

    public static void main(String[] args) {

        String str = "Java Concept Of The Day";
        String a= "bhavana";

        String rev = String.valueOf(new StringBuffer(a).reverse());
        System.out.println(rev);

        String revStr = Arrays.stream(str.split(" "))
                .map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining(" "));

        System.out.println(revStr);
    }



}
