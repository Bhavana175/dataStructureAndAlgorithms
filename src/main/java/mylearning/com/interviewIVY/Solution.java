package mylearning.com.interviewIVY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Solution {


    /*

    1) Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

    Example 1:
    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]
    Example 2:

    Input: nums = [1], k = 1
    Output: [1]

     */

    public static void main(String[] args) {

        int [] nums = {1,1,1,2,2,3}; int k = 2;
        int [] output = getKMostFrequentElement(nums, k);
        System.out.println(Arrays.toString(output));


    }

    private static int[] getKMostFrequentElement(int[] nums, int k) {


        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int [] output = new int[k];

        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)+1);
        }

        List<HashMap.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());
        //list.addAll(freqMap.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for (int i = 0; i < k; i++) {
           output[i]= list.get(i).getKey();
        }

        return output;
    }

}
