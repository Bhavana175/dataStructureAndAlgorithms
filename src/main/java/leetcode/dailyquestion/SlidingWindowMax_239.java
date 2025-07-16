package leetcode.dailyquestion;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMax_239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7}; // Output: [3,3,5,5,6,7]
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int [] {1,-1}, 1)));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int[] output = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            priorityQueue.offer(new int[]{nums[i], i});

            if (i >= k - 1) {
                while (priorityQueue.peek()[1] <= i - k) {
                    priorityQueue.poll();
                }
                output[i - k + 1] = priorityQueue.peek()[0];
            }
        }
        return output;
    }

}
