package mylearning.com.question.arrays;

public class HouseRobber {

/*    You are a professional robber planning to rob houses along a street.
      Each house has a certain amount of money stashed, the only constraint
      stopping you from robbing each of them is that adjacent houses have
      security systems connected, it will automatically contact the police
      if two adjacent houses were broken into on the same night.

      Given an integer array nums representing the amount of money of each house,
      return the maximum amount of money you can rob tonight without alerting the police.
      Example 1:

      Input: nums = [1,2,3,1]
      Output: 4
      Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3)
      Total amount you can rob = 1 +   3 = 4.*/

    public static void main(String[] args) {

        HouseRobber obj = new HouseRobber();
        int[] houseArr = {2,1,2,6,1,8,10,10};
        System.out.println("output : " + obj.rob(houseArr));

    }

    public int rob(int[] nums) {

        int amount1 = 0, amount2 = 0, amount3 = 0, amount4 = 0;

        for (int i = 0; i < nums.length; i = i + 2) {
            amount1 = amount1 + nums[i];
        }
        for (int j = 1; j < nums.length; j = j + 2) {
            amount2 = amount2 + nums[j];
        }

        for (int i = 0; i < nums.length; ) {

            if (i + 3 < nums.length && nums[i] + nums[i + 3] > nums[i] + nums[i + 2]) {

                if (amount3 == 0) {
                    amount3 = amount3 + nums[i] + nums[i + 3];
                } else {
                    amount3 = amount3 + nums[i + 3];
                }
                i = i + 3;
            } else if (i + 2 < nums.length) {
                if (nums[i] + nums[i + 2] > nums[i + 1]) {
                    if (amount3 == 0) {
                        amount3 = amount3 + nums[i] + nums[i + 2];
                    } else {
                        amount3 = amount3 + nums[i + 2];
                    }
                    i = i + 2;
                } else {
                    amount3 = amount3 + nums[i + 1];
                    i = i + 1;
                }
            } else {
                i = i + 1;
            }
        }

        for (int i = 1; i < nums.length; ) {

            if (i + 3 < nums.length && nums[i] + nums[i + 3] > nums[i] + nums[i + 2]) {
                if (amount4 == 0) {
                    amount4 = amount4 + nums[i] + nums[i + 3];
                } else {

                    amount4 = amount4 + nums[i + 3];
                }
                i = i + 3;
            } else if (i + 2 < nums.length) {
                if (nums[i] + nums[i + 2] > nums[i + 1]) {
                    if (amount4 == 0) {
                        amount4 = amount4 + nums[i] + nums[i + 2];

                    } else {
                        amount4 = amount4 + nums[i + 2];
                    }
                    i = i + 2;
                } else {

                    amount4 = amount4 + nums[i + 1];

                    i = i + 1;
                }
            } else {
                i = i + 1;
            }
        }

        return Math.max(amount4, Math.max(amount3, Math.max(amount1, amount2)));
        // return (amount1>amount2)? amount1: amount2;
    }

}
