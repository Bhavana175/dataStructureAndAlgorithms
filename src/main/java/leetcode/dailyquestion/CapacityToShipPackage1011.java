package leetcode.dailyquestion;

public class CapacityToShipPackage1011 {
    public static void main(String[] args) {
        int [] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {

        int minCapacity = 0, maxCapacity = 0;
        for (int wt : weights) {
            minCapacity = Math.max(minCapacity, wt); // At least the max weight
            maxCapacity += wt; // At most sum of all weights
        }

        int result = maxCapacity;

        while (minCapacity <= maxCapacity) {
            int mid = (maxCapacity + minCapacity) / 2;
            if (possibleToShipPackages(weights, days, mid)) {
                result = mid;
                maxCapacity = mid - 1;
            } else {
                minCapacity = mid + 1;
            }
        }
        return result;
    }

    private static boolean possibleToShipPackages(int[] weights, int days, int totalWeightCapacity) {

        int sumWeight = 0;
        int count = 0;

        for (int i = 0; i < weights.length; i++) {
            sumWeight += weights[i];
            if (sumWeight > totalWeightCapacity) {
                count++;
                sumWeight = weights[i];
            }
            if (count >= days) {
                return false;
            }
        }
        return true;
    }
}
