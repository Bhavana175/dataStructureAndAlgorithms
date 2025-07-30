package leetcode.dailyquestion;

public class LongestSubArrayMaxBitwiseAND_2419 {
    public static void main(String[] args) {

    }
    public int longestSubarray(int[] nums) {
        //whenever we do AND operation max value is decreases
        int max =0;
        int maxCount =0;
        int count =0;

        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            while (i<nums.length && max == nums[i]){
                count++;
                maxCount = Math.max(maxCount, count);
                i++;
            }
            count =0;
        }
        return maxCount;
    }
}
