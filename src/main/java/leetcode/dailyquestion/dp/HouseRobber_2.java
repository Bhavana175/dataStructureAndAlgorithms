package leetcode.dailyquestion.dp;

public class HouseRobber_2 {
    public static void main(String[] args) {
        int [] nums = {2,3,2};
        System.out.println(new HouseRobber_2().rob(nums));

    }
    public int rob(int[] nums) {
        int n = nums.length;
        int [] arr1 = new int[n-1];
        int [] arr2 = new int[n-1];

        for (int i = 0; i < n; i++) {
            if(i!=0) arr1[i-1] = nums[i];
            if(i!=n-1) arr2[i] = nums[i];
        }

        return Math.max(robHouse(arr1), robHouse(arr2));

    }

    private int robHouse(int[] arr) {
        int n = arr.length;
        int [] t = new int[n];

        t[0] = arr[0];

        for (int i = 1; i <n ; i++) {
            int rob = arr[i];
            if(i>1) rob = t[i-1]+arr[i];

            t[i] = Math.max(rob, t[i-1]);
        }
       return t[n-1];
    }
}
