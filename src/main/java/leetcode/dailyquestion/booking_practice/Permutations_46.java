package leetcode.dailyquestion.booking_practice;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> singleList = new ArrayList<>();
        backTrack(nums, singleList, result);

        return result;
    }

    private static void backTrack(int[] nums, List<Integer> singleList, List<List<Integer>> result) {

        if (singleList.size() == nums.length) {
            result.add(new ArrayList<>(singleList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (singleList.contains(nums[i])) continue;
            singleList.add(nums[i]);
            backTrack(nums, singleList, result);
            singleList.remove(singleList.size() - 1);
        }

    }
}
