package leetcode.dailyquestion.dp.lcs;

public class FindTheMaxLenOfValidSubSequence_II_3202 {
    public static void main(String[] args) {
        int [] nums = {1,4,2,3,1,4};
        int k = 3;
        System.out.println(maximumLength(nums, k));
    }

    public static int maximumLength(int[] nums, int k) {

        int n = nums.length;
        int[][] dp = new int[n][k];

        int result = 1;

        for (int i = 0; i < n; i++) {
            // Initialize all mod classes with length 1 (just the element itself)
            for (int mod = 0; mod < k; mod++) {
                dp[i][mod] = 1;
            }

            for (int j = 0; j < i; j++) {
                int mod = (nums[j] + nums[i]) % k;
                dp[i][mod] = Math.max(dp[i][mod], dp[j][mod] + 1);
                result = Math.max(result, dp[i][mod]);
            }
        }

        return result;
    }
}
