package leetcode.dailyquestion;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfGoodSubarrays2537 {

    public static void main(String[] args) {

    }

    public long countGood(int[] nums, int k) {

        int l = 0;
        int r = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        long goodSubArray = 0;
        int n = nums.length;
        int pairCount = 0;

        while (l < n) {

            while (r < n && pairCount < k) {
                freqMap.put(nums[r], freqMap.getOrDefault(nums[r], 0) + 1);
                if (freqMap.get(nums[r]) > 1) {
                    pairCount += freqMap.get(nums[r]) - 1;
                }
                r++;
            }

            if (pairCount >= k) {
                goodSubArray += n - r + 1;
            }

            int freq = freqMap.get(nums[l]);
            pairCount -= freq - 1;
            freqMap.put(nums[l], freq - 1);
            l++;
        }

        return goodSubArray;

    }
}
