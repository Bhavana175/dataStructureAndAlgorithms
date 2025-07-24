package leetcode.dailyquestion;

import java.util.HashSet;

public class MaximumErasureValue_1695 {
    public static void main(String[] args) {
        int[] nums = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        System.out.println(maximumUniqueSubarray(nums));
    }

    public static int maximumUniqueSubarray(int[] nums) {

        int i = 0;
        int start = 0;
        int rank = 0;
        int output = 0;
        HashSet<Integer> set = new HashSet<>();
        while (i < nums.length) {
            rank += nums[i];

            while (!set.add(nums[i])) {
                set.remove(nums[start]);
                rank -= nums[start];
                start++;
            }

            output = Math.max(output, rank);
            i++;
        }
        return output;
    }
}
