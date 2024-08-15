package mylearning.com.interviewwalmart1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    /*
    set of integers
    first not repeating element

        List<Integer> list =
     */

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,6,4,8,6,8,9);

        int output = findFirstNonRepeatingElement(list);
        System.out.println(output);

    }

    private static int findFirstNonRepeatingElement( List<Integer> list) {

        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), map.getOrDefault(list.get(i),0)+1);
        }

        for (int i = 0; i < list.size(); i++) {
            if(map.containsKey(list.get(i)) && map.get(list.get(i))==1){
                return list.get(i);
            }
        }

        return 0;
    }

}
