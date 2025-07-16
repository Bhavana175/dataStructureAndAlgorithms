package leetcode.dailyquestion.dp.lcs;

public class FindTheMAxLenOfValidSubSequence_3201 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 2, 1, 2};
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(maximumLength(nums));
        System.out.println(maximumLength(nums1));
    }

    public static int maximumLength(int[] nums) {
        int prev = nums[0];
        int even = 0;
        int odd = 0;
        int alt = 1;

        if (prev % 2 == 0) {
            even++;
        } else odd++;

        for (int i = 1; i < nums.length; i++) {
            if (prev % 2 != nums[i] % 2) {
                alt++;
                prev = nums[i];
            }
            if (nums[i] % 2 == 0) {
                even++;
            } else odd++;
        }
        return Math.max(alt, Math.max(even, odd));
    }
}
