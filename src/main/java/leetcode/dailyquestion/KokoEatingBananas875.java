package leetcode.dailyquestion;

public class KokoEatingBananas875 {
    public static void main(String[] args) {
       // int[] piles = {805306368,805306368,805306368};
       // int h = 1000000000;
        int [] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int maxValue = 0;
        for (int val : piles) {
            maxValue = Math.max(maxValue, val);
        }

        int l = 1, r = maxValue;
        int minSpeed = -1; // We'll store the smallest valid speed here

        while (l <= r) {
            int mid = l + (r - l) / 2;  // Avoid potential overflow
            long timeToEatBanana = 0;

            for (int pile : piles) {
                timeToEatBanana += (pile + mid - 1) / mid; // Simulates Math.ceil((double)pile / mid)
            }

            if (timeToEatBanana <= h) {
                minSpeed = mid;  // Valid speed found — try slower
                r = mid - 1;
            } else {
                l = mid + 1;      // Too slow — try faster
            }
        }

        return minSpeed;
    }
}
