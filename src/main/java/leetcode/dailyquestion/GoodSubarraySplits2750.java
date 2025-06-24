package leetcode.dailyquestion;

public class GoodSubarraySplits2750 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 0, 1, 0};
        System.out.println(numberOfGoodSubarraySplits(arr));
    }

    public static int numberOfGoodSubarraySplits(int[] nums) {

        int count = 0;
        int ans = 1;
        int MOD = 1000000007;
        boolean flag = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                flag = true;
                ans = (ans * (count + 1)) % MOD;
                count = 0;
            } else if (nums[i] == 0 && flag) {
                count++;
            }
        }
        if (!flag) return 0;
        return ans % MOD;
    }
}
