package com.workspace.learning.interviews.wanerbrospractice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    //https://leetcode.com/problems/rotting-oranges/description/

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int output = orangesRotting(grid);
        System.out.println(output);
        System.out.println();
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int output1 = orangesRottingLeet(grid1);
        System.out.println(output1);

    }

    public static int orangesRotting(int[][] grid) {
        //2 is rotten , start point should be 2, multiple 2 can be there add in queue index
        // count fresh oranges
        // traverse  4 direction  i+1,j , i-1,j   i,j+1   i,j-1 from rotten orange
        //  grid[i+1][j]==1 etc =2 freshcount -- add to queue
        // till queue is empty

        int m = grid.length, n = grid[0].length;
        int minTime = -1, freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // inside queue, we have all the rotten oranges index

        while (!queue.isEmpty()) {
            minTime++;
            int size = queue.size();

            // this array has two index i,j from grid
            int i = 0;
            while (i < size) {
                int[] curr = queue.poll();
                if (curr[0] + 1 < m && grid[curr[0] + 1][curr[1]] == 1) {
                    grid[curr[0] + 1][curr[1]] = 2;
                    freshCount--;
                    queue.offer(new int[]{curr[0] + 1, curr[1]});
                }
                if (0 <= curr[0] - 1 && grid[curr[0] - 1][curr[1]] == 1) {
                    grid[curr[0] - 1][curr[1]] = 2;
                    freshCount--;
                    queue.offer(new int[]{curr[0] - 1, curr[1]});
                }
                if (curr[1] + 1 < n && grid[curr[0]][curr[1] + 1] == 1) {
                    grid[curr[0]][curr[1] + 1] = 2;
                    freshCount--;
                    queue.offer(new int[]{curr[0], curr[1] + 1});
                }
                if (0 <= curr[1] - 1 && grid[curr[0]][curr[1] - 1] == 1) {
                    grid[curr[0]][curr[1] - 1] = 2;
                    freshCount--;
                    queue.offer(new int[]{curr[0], curr[1] - 1});
                }
                i++;
            }
        }
        if (freshCount > 0) {
            return -1;
        }

        return minTime;

    }

    public static int orangesRottingLeet(int[][] grid) {
        int xlen = grid.length, ylen = grid[0].length, ans = -1;
// Queue to keep the rotten blocks
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0; // Count for freshOrange blocks
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
// Add all the rotten to Queue and update freshCount for fresh oranges.
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0; // No fresh oranges, return 0.
        }
        int temp = 0, level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
// increase the level (ans) for output, Process the full queue for that minute.
            for (int i = 0; i < size; i++) {
// Check in all 4 directions, reduce the freshOrange count, update the grid and mark as rotten in that minute.
                int[] p = queue.poll();
                if (p[1] + 1 < ylen && grid[p[0]][p[1] + 1] == 1) {
                    grid[p[0]][p[1] + 1] = 2;
                    queue.offer(new int[]{p[0], p[1] + 1});
                    freshCount--;
                }
                if (p[1] - 1 >= 0 && grid[p[0]][p[1] - 1] == 1) {
                    grid[p[0]][p[1] - 1] = 2;
                    queue.offer(new int[]{p[0], p[1] - 1});
                    freshCount--;
                }
                if (p[0] + 1 < xlen && grid[p[0] + 1][p[1]] == 1) {
                    grid[p[0] + 1][p[1]] = 2;
                    queue.offer(new int[]{p[0] + 1, p[1]});
                    freshCount--;
                }
                if (p[0] - 1 >= 0 && grid[p[0] - 1][p[1]] == 1) {
                    grid[p[0] - 1][p[1]] = 2;
                    queue.offer(new int[]{p[0] - 1, p[1]});
                    freshCount--;
                }
            }
        }
// Still any fresh oranges are left, return -1, otherwise return ans;
        if (freshCount > 0) {
            return -1;
        }
        return ans;
    }

}
