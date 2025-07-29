package leetcode.dailyquestion;
import java.util.Arrays;

public class SmallestSubArrayWithMaxBitOR_2411 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 1, 3};
        System.out.println(Arrays.toString(smallestSubarrays(nums)));
    }

    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int maxOR = 0;
        for (int num : nums) {
            maxOR |= num;
        }
        int[] lastSetBitIndex = new int[Integer.toBinaryString(maxOR).length()];
        Arrays.fill(lastSetBitIndex, n);
        //right to left maintain the nearest set bit array
        for (int i = n - 1; i >= 0; i--) {
            int nearest = i;
            for (int j = 0; j < lastSetBitIndex.length; j++) {
                //check Jth bit is set in nums
                if ((nums[i] & 1 << j) != 0) {
                    lastSetBitIndex[j] = i; // update index for set bit
                } else if (lastSetBitIndex[j] != n) {
                    nearest = Math.max(nearest, lastSetBitIndex[j]);
                }
            }
            output[i] = nearest-i+1;
        }
        return output;
    }
}
