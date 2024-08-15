package mylearning.com.interview2;

import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * INFOSYS
     *output : 10,15,118
     */
        public static void main(String args[]) {
            List<Integer> myList = Arrays.asList(10,15,118,49,25,98,32);
           myList.stream().map(s -> s + "").filter(str->str.contains("1"))
                 .forEach(System.out::println);
        }

}
