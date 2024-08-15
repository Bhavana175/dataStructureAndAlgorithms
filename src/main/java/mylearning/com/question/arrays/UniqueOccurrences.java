package mylearning.com.question.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueOccurrences {

    /*
    Given an array of integers arr, return true if the number of occurrences of each
    value in the array is unique or false otherwise.
    Example 1:
    Input: arr = [1,2,2,1,1,3]
    Output: true
    Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two
    values have the same number of occurrences.

    */

    public static void main(String[] args) {

        UniqueOccurrences obj = new UniqueOccurrences();
        int[] arr = {1, 2, 2, 3, 4, 1};
        System.out.println("output :  " + obj.uniqueOccurrences(arr));
    }

    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> uniqueMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            uniqueMap.put(arr[i], uniqueMap.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry entry : uniqueMap.entrySet()
        ) {
            if (!set.add((Integer) entry.getValue())) {
                return false;
            }
        }
        return true;

    }

}
