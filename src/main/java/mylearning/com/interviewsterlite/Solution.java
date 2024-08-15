package mylearning.com.interviewsterlite;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        //first non-repeating character from a String java 8

        String s = "aabbcdrdcm";
        //output r

        Map<Character, Long> collect = s.chars().mapToObj((ch) -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int i = 0; i < s.length(); i++) {

            if(collect.containsKey(s.charAt(i)) && collect.get(s.charAt(i))==1){
                System.out.println(" Non repeating char "+ s.charAt(i));
                break;
            }

        }

    }

}
