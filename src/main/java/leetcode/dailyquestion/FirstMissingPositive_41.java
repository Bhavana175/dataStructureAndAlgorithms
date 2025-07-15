package leetcode.dailyquestion;

import java.util.Arrays;

public class FirstMissingPositive_41 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        // Output 3
        int[] nums2 = {7, 8, 9, 11, 12};
        // Output 1
        int[] nums3 = {1, 2, 3, 7, 11};
        // Output 4
        int[] nums4 = {-1, 1, 3, 4};
        // Output 2
        int[] nums5 = {-5, -3, -1, 0, 1, 4, 11};
        // // Output 2
        System.out.println(firstMissingPositiveStrictlyIncreasingArray(nums1));
        System.out.println(firstMissingPositiveStrictlyIncreasingArray(nums2));
        System.out.println(firstMissingPositiveStrictlyIncreasingArray(nums3));
        System.out.println(firstMissingPositiveStrictlyIncreasingArray(nums4));
        System.out.println(firstMissingPositiveStrictlyIncreasingArray(nums5));
        System.out.println(firstMissingPositive(nums5));

    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];
        for(int num : nums){
            if(num > 0 && num <= n){
                seen[num] = true;
            }
        }
        for(int i = 1; i <= n; i++){
            if(!seen[i]) return i;
        }
        return n + 1;
    }

    public static int firstMissingPositiveStrictlyIncreasingArray(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 0 && nums[0] != 1) {
            return 1;
        }

        int n = nums.length;
        int start = 0;
        int end = nums.length - 1;

        // find first positive number
        if (nums[0] <= 0) {
            while (start <= end) {
                int mid = (start + end) / 2;
                if (nums[mid] > 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        // first positive index
        int l = start;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == mid - start + 1) {
                l = mid + 1;
            } else r = mid - 1;
        }

        return l - start + 1;
    }
}
