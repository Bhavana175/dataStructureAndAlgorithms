package leetcode.dailyquestion.booking_practice;

public class MaximalSquare_221 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {

        //square if all are 1
        int n = matrix.length, m = matrix[0].length;
        int[][] t = new int[n][m];
        int maxWidth = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = matrix[i][j] - '0';
                    maxWidth = Math.max(maxWidth, t[i][j]);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '1') {
                    t[i][j] = 1 + Math.min(Math.min(t[i - 1][j], t[i][j - 1]), t[i - 1][j - 1]);
                    maxWidth = Math.max(maxWidth, t[i][j]);
                } else t[i][j] = 0;
            }
        }
        return maxWidth * maxWidth;
    }
}
