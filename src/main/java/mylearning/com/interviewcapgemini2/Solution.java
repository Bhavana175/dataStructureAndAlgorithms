package mylearning.com.interviewcapgemini2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Bhavana", "Ram", "Syam", "Sita", "Sheetal");

        Map<Character, List<String>> collect = list.stream().collect(Collectors.groupingBy((name) -> name.charAt(0)));

        collect.entrySet().forEach((e) -> {System.out.println(e.getKey());System.out.println(e.getValue());});

    }

}
