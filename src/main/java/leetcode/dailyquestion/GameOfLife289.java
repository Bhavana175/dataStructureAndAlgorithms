package leetcode.dailyquestion;

import java.util.Arrays;

public class GameOfLife289 {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        //  Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int liveNeighbours =
                        neighbour(board, i - 1, j) +
                                neighbour(board, i + 1, j) +
                                neighbour(board, i, j - 1) +
                                neighbour(board, i, j + 1) +
                                neighbour(board, i + 1, j + 1) +
                                neighbour(board, i + 1, j - 1) +
                                neighbour(board, i - 1, j + 1) +
                                neighbour(board, i - 1, j - 1);

                if (board[i][j] == 1) {
                    //either die fewer thn 2 , more thn 3
                    if (liveNeighbours < 2 || liveNeighbours > 3) {
                        temp[i][j] = 0;
                    } else temp[i][j] = board[i][j];
                } else {
                    if (liveNeighbours == 3) {
                        temp[i][j] = 1;
                    }
                }

            }

        }

        for (int i = 0; i < n; i++) {
            board[i] = temp[i].clone();
        }
        System.out.println(Arrays.deepToString(board));
    }

    private static int neighbour(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 0) return 0;
        return 1;
    }
}
