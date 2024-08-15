package mylearning.com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class FirstElement {
  //  public static <T> T;
    /**
     * Given a stream containing some elements, the task is to get the first element of the Stream in Java.
     * Example:
     * Input: Stream = {“Geek_First”, “Geek_2”, “Geek_3”, “Geek_4”, “Geek_Last”}
     * Output: Geek_First
     * Input: Stream = {1, 2, 3, 4, 5, 6, 7}
     * Output: 1
     */

    public static void main(String[] args) {

        FirstElement fe= new FirstElement();
        List<String> list = Arrays.asList("Geek_First", "Geek_2", "Geek_3", "Geek_4", "Geek_Last");
        Stream<String> stream
                = Stream.of("Geek_First", "Geek_2",
                "Geek_3", "Geek_4",
                "Geek_Last");
        Stream<Integer> stream1
                = Stream.of(1, 2, 3, 4, 5, 6, 7);

        System.out.println("output : "+fe.getFirstElement(list));

        System.out.println("output : "+fe.getFirstElementStream(stream));

        System.out.println("output : "+fe.getFirstElementStream(stream1));
    }

    private <T> T getFirstElementStream(Stream<T> stream) {

        return  stream.reduce((a, b)->a).orElse(null);
    }

    private String getFirstElement(List<String> list) {

        //use stream
        return list.stream().findFirst().orElse("Not found");

    }

}
