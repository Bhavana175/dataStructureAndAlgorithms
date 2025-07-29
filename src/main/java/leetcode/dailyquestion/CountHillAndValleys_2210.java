package leetcode.dailyquestion;

public class CountHillAndValleys_2210 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 1, 6, 5};
        System.out.println(countHillValley(nums));
    }

    public static int countHillValley(int[] nums) {
        int count = 0;
        int j = 0;
        int n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            if ((nums[j] < nums[i] && nums[i] > nums[i + 1]) ||
                    (nums[j] > nums[i] && nums[i] < nums[i + 1])) {
                count++;
                j = i;
            }
        }
        return count;
    }
}
