package mylearning.com.interviewPugmatic;

public class Solution {
    /*
    You are given an integer array nums. You are initially positioned at the array's first index,
    and each element in the array represents your maximum jump length at that position.
	Return true if you can reach the last index, or false otherwise.

	Input: nums = [2,3,1,1,4]
	Output: true
	Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

	Input: nums = [3,2,1,0,4]
	Output: false
	Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

     */

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {3, 2, 2, 0, 4};
        int[] nums4 = {3,2,2,0,2,0,2,0,2,0,1,4};

        boolean output = jumpToReachLastIndex(nums);
        boolean output1 = jumpToReachLastIndex(nums2);
        boolean output2 = jumpToReachLastIndex(nums3);
        boolean output3 = jumpToReachLastIndex(nums4);
        System.out.println(output);
        System.out.println(output1);
        System.out.println(output2);
        System.out.println(output3);
    }

    private static boolean jumpToReachLastIndex(int[] arr) {

/*        if (arr.length == 1) {
            return true;
        }

        int lastIndex = arr.length - 1;
        int currIndex = 0;

        for (int i = 0; i < arr.length; i++) {

            int count = arr[i];
            while (count > 0) {
                int k = currIndex + count;
                if (k + arr[k] == lastIndex) {
                    return true;
                }
                count--;
            }
        }

        return false;*/

        int maxDistance = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i > maxDistance) return false;
            maxDistance = Math.max(maxDistance, i + arr[i]);
        }
        return true;
    }

}
