package mylearning.com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Average {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(20,40,40,10,30,20,80,0,40,40);

        System.out.println("Average output :"+calculateAverage(list));

    }

    private static Double calculateAverage(List<Integer> list) {

       return list.stream()
               .mapToDouble(Integer::doubleValue)
               .average()
               .orElse(0.0);

    }

}
