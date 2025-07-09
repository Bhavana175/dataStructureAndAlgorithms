package leetcode.dailyquestion.dp;

public class JumpGame_55 {
    public static void main(String[] args) {

        int [] nums = { 2,3,1,1,4};
      //  System.out.println(canJump(nums));
        System.out.println(jump_II(nums));

    }
    public static boolean canJump(int[] nums) {
        int maxDistance = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxDistance) return false;
            maxDistance = Math.max(maxDistance, i + nums[i]);
        }
        return true;
    }

    public static int jump_II(int[] nums) {
        int minJump =0;
        int maxJump =0;
        int curr = 0;

        for(int i=0; i<nums.length-1; i++){

            maxJump = Math.max(maxJump, nums[i]+i);

            if(i==curr){
                curr = maxJump;
                minJump++;
            }

        }
        return minJump;
    }
}
