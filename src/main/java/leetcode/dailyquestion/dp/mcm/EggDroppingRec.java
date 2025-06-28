package leetcode.dailyquestion.dp.mcm;

public class EggDroppingRec {
    public static void main(String[] args) {
        //find min number of attempts
        System.out.println(finMinNumberOfAttempts(3, 10));
    }

    private static int finMinNumberOfAttempts(int eggs, int floor) {

        if (floor == 1 || floor == 0) {
            return floor;
        }
        if (eggs == 0) {
            return floor;
        }
        int min = Integer.MAX_VALUE;
        for (int k = 1; k < floor; k++) {

            int tempWorstAttempt = 1 + Math.max(finMinNumberOfAttempts(eggs - 1, k),
                    finMinNumberOfAttempts(eggs, floor - k));

            min = Math.min(min, tempWorstAttempt);

        }

        return min;
    }
}
