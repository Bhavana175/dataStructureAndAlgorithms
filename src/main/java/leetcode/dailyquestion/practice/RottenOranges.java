package leetcode.dailyquestion.practice;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        //1 fresh, 2 rotten , bfs
        int time = -1;
        int freshCount = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    vis[i][j] = true;
                } else if (grid[i][j] == 1) {
                    freshCount++;
                } else vis[i][j] = true;
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            time++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int index1 = curr[0];
                int index2 = curr[1];

                // all 4 direction
                if (index1 < n - 1 && !vis[index1 + 1][index2] && grid[index1 + 1][index2] == 1) {
                    grid[index1 + 1][index2] = 2;
                    vis[index1 + 1][index2] = true;
                    freshCount--;
                    queue.offer(new int[]{index1 + 1, index2});
                }
                if (0 < index1 && !vis[index1 - 1][index2] && grid[index1 - 1][index2] == 1) {
                    grid[index1 - 1][index2] = 2;
                    vis[index1 - 1][index2] = true;
                    freshCount--;
                    queue.offer(new int[]{index1 - 1, index2});
                }
                if (index2 < m - 1 && !vis[index1][index2 + 1] && grid[index1][index2 + 1] == 1) {
                    grid[index1][index2 + 1] = 2;
                    vis[index1][index2 + 1] = true;
                    freshCount--;
                    queue.offer(new int[]{index1, index2 + 1});
                }
                if (0 < index2 && !vis[index1][index2 - 1] && grid[index1][index2 - 1] == 1) {
                    grid[index1][index2 - 1] =2;
                    vis[index1][index2 - 1] =true;
                    freshCount--;
                    queue.offer(new int[]{index1, index2 - 1});
                }
            }
        }

        return freshCount > 0 ? -1 : time;
    }
}
