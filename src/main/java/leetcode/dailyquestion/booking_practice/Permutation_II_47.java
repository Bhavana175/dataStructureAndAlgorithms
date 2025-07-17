package leetcode.dailyquestion.booking_practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation_II_47 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 2, 4}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        List<Integer> combinationList = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backTrack(nums, vis, result, combinationList);
        return result.stream().toList();
    }

    private static void backTrack(int[] nums, boolean[] vis, Set<List<Integer>> result, List<Integer> combinationList) {

        if (combinationList.size() == nums.length) {
            result.add(new ArrayList<>(combinationList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                combinationList.add(nums[i]);
                backTrack(nums,vis, result, combinationList);
                combinationList.remove(combinationList.size() - 1);
                vis[i] = false;
            }
        }

    }
}
