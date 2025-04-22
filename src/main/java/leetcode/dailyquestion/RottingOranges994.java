package leetcode.dailyquestion;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges994 {

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        RottingOranges994 obj = new RottingOranges994();
        System.out.println(obj.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[n][m];
        int time = -1;
        int freshCount = 0;
        //find all the rotten oranges

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    vis[i][j] = true;
                } else if (grid[i][j] == 0) {
                    vis[i][j] = true;
                } else freshCount++;
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            time++;
            for (int i = 0; i < size; i++) {

                int[] arr = queue.poll();
                int index1 = arr[0];
                int index2 = arr[1];

                if (index1 > 0 && !vis[index1 - 1][index2]) {
                    vis[index1 - 1][index2] = true;
                    grid[index1 - 1][index2] = 2;
                    freshCount--;
                    queue.offer(new int[]{index1 - 1, index2});
                }
                if (index2 > 0 && !vis[index1][index2 - 1]) {
                    vis[index1][index2 - 1] = true;
                    grid[index1][index2 - 1] = 2;
                    freshCount--;
                    queue.offer(new int[]{index1, index2 - 1});
                }
                if (index1 < n - 1 && !vis[index1 + 1][index2]) {
                    vis[index1 + 1][index2] = true;
                    grid[index1 + 1][index2] = 2;
                    freshCount--;
                    queue.offer(new int[]{index1 + 1, index2});
                }
                if (index2 < m - 1 && !vis[index1][index2 + 1]) {
                    vis[index1][index2 + 1] = true;
                    grid[index1][index2 + 1] = 2;
                    freshCount--;
                    queue.offer(new int[]{index1, index2 + 1});
                }

            }
        }

        if (freshCount > 0) {
            return -1;
        }

        return time;
    }
}