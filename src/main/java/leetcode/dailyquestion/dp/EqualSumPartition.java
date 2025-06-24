package leetcode.dailyquestion.dp;

public class EqualSumPartition {

    public static void main(String[] args) {
        int[] arr = {2, 7, 3, 10, 4, 1};
        System.out.println(isEqualSumPartition(arr));
    }

    public static boolean isEqualSumPartition(int[] arr) {

        /*
        [2,7,3,10,4,2] equal sum possible? [2,7,3,2] [10,4] sum=14, 14
         */

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        return subsetSumProblem(arr, sum / 2);

    }

    private static boolean subsetSumProblem(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][sum + 1];

        //base condition
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int sumj = 1; sumj < sum + 1; sumj++) {
                //choice diagram
                if (arr[i - 1] <= sumj) {
                    //either take it or leave it, use or as true || false = ? true
                    t[i][sumj] = t[i - 1][sumj - arr[i - 1]] || t[i - 1][sumj];
                } else t[i][sumj] = t[i - 1][sumj];
            }
        }

        return t[n][sum];

    }
}
