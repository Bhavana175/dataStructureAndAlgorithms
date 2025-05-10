package leetcode.dailyquestion.dp;

public class HouseRobberII213 {

    public static void main(String[] args) {
        int [] nums = {2,3,2};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {

        int n = nums.length;
        int [] arr1 = new int[n];
        int [] arr2 = new int[n];
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        //construct 2 array
        for (int i = 0; i < n; i++) {
            if(i!=0) arr1[i] = nums[i];
            if(i!=n-1) arr2[i] = nums[i];
        }

        return Math.max(robMax(arr1), robMax(arr2));
    }

    public static  int robMax(int [] nums){

        int n = nums.length;
        int [] dp = new int[nums.length];

        dp[0] = nums[0];
        for (int i = 1; i <n ; i++) {
            int rob = nums[i];
            if(i>1) rob+= dp[i-2];
            int notRob = dp[i-1];
            dp[i] = Math.max(rob, notRob);
        }
        return dp[n-1];
    }
}
