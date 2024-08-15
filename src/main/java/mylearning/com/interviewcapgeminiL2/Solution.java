package mylearning.com.interviewcapgeminiL2;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        //capgemini 2nd round

        // first non-repeating character from string "Hello"

        String str = "Hello";
        System.out.println(str);

        Map<Character, Long> map = str.chars().mapToObj((ch) -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i)) && map.get(str.charAt(i))==1){
                System.out.println("First non repeating char  "+str.charAt(i));
                break;
            }
        }

    }

}
