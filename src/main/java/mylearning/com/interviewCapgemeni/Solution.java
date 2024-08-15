package mylearning.com.interviewCapgemeni;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {


    /*
    find duplicate elements in list using stream api
eg- [2,3,4,2,5,8,3,6]
     */

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = Arrays.asList(2,3,4,2,5,8,3,6);

        list.stream().filter((num)-> !set.add(num)).forEach(System.out::println);

    }
}
