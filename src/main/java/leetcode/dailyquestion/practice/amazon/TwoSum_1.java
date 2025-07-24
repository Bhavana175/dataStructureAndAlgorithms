package leetcode.dailyquestion.practice.amazon;

import java.util.HashMap;

public class TwoSum_1 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int [] output = new int [2];
        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(nums[i])){
                output = new int []{map.get(nums[i]), i};
                break;
            }
            map.put(target-nums[i], i);
        }
        return output;
    }
}
