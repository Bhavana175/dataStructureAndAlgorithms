package leetcode.dailyquestion;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls1552 {
    public static void main(String[] args) {

    }

    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);
        int n = position.length;
        int minForce = 1;
        int maxForce = position[n - 1] - position[0];
        int result = 0;
        while (minForce <= maxForce) {

            int mid = (minForce + maxForce) / 2;
            if (possibleToPlaceBalls(position, mid, m)) {
                result = mid;
                minForce = mid + 1;
            } else maxForce = mid - 1;
        }
        return result;
    }

    private boolean possibleToPlaceBalls(int[] position, int force, int m) {
        int count = 1;
        int prevPosition = position[0];

        for (int i = 0; i < position.length; i++) {
            if (position[i] - prevPosition >= force) {
                count++;
                prevPosition = position[i];
            }
            if (count == m) {
                return true;
            }
        }
        return false;
    }
}
