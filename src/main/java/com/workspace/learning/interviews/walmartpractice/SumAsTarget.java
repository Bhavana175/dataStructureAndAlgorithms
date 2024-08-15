package com.workspace.learning.interviews.walmartpractice;

import java.util.Arrays;
import java.util.HashMap;

public class SumAsTarget {

    public static void main(String[] args) {

        int [] nums = {1,4,6,3,8,55,3,9,20};
        int target = 23;

        int [] output = getSumAsTarget(nums, 7);
        System.out.println(Arrays.toString(output));

    }

    private static int[] getSumAsTarget(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(nums[i])){
                return new int [] {map.get(nums[i]),i};
            }else {
                map.put(target-nums[i], i);
            }

        }
        return new int []{0,0};
    }

}
