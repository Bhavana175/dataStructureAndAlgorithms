package leetcode.dailyquestion.practice.amazon;

import java.util.*;

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    //O(N^2)
    public static List<List<Integer>> threeSum_improved(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int one = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = one + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++; // skip duplicates
                    while (l < r && nums[r] == nums[r - 1]) r--; // skip duplicates
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else r--;
            }
        }
        return result;
    }


    // bad time complexity O(N^3)
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int one = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int l = j;
                int r = nums.length - 1;

                while (l < r) {
                    int sum = one + nums[l] + nums[r];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        l++;
                        r--;
                    } else if (sum < 0) {
                        l++;
                    } else r--;
                }
            }

        }
        return result.stream().toList();
    }
}
