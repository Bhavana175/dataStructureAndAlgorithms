package leetcode.dailyquestion;

public class CountNumberOfMaxBitORSubset_2044 {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        System.out.println(countMaxOrSubsets(nums));
    }

    public static int countMaxOrSubsets(int[] nums) {

        // note count subset for max bitwise or subset not a subArray
        int maxOR = 0; // or of all element in an array (1|1 =1, 1|0=1, 0|1=1, 0|0 =0)

        for (int num : nums) {
            maxOR |= num;
        }
        return backTrack(maxOR, nums, 0, 0 );

    }

    private static int backTrack(int maxOR, int[] nums, int i, int currOR) {

        if (i == nums.length) {
            if (currOR == maxOR) {
                return 1;
            }
            return 0;
        }

        int include = backTrack(maxOR, nums, i + 1, currOR | nums[i]);
        int exclude = backTrack(maxOR, nums, i + 1, currOR);

        return include + exclude;
    }
}
