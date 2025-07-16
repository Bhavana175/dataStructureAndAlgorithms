package leetcode.dailyquestion.booking_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColoringABorder_1034 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int row = 1, col = 1, color = 2;
        int[][] grid1 = {{1, 2, 1, 2, 1, 2}, {2, 2, 2, 2, 1, 2}, {1, 2, 2, 2, 1, 2}}; //[[1,2,1,2,1,2],[2,2,2,2,1,2],[1,2,2,2,1,2]]
        int row1 = 1, col1 = 1, color1 = 1;
        //  System.out.println(Arrays.deepToString(colorBorder(grid, row, col, color)));
        System.out.println(Arrays.deepToString(colorBorder(grid1, row1, col1, color1)));
    }

    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length;
        int m = grid[0].length;
        List<int[]> borderList = new ArrayList<>();
        boolean[][] vis = new boolean[n][m];

        dfs(grid, vis, row, col, grid[row][col], borderList);

        for (int[] cell : borderList) {
            grid[cell[0]][cell[1]] = color;
        }

        return grid;
    }

    private static void dfs(int[][] grid, boolean[][] vis, int row, int col, int originalColor, List<int[]> borderList) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int sameColorNeighbour = 0;
        vis[row][col] = true;

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                if (grid[newRow][newCol] == originalColor) {
                    if (!vis[newRow][newCol]) {
                        dfs(grid, vis, newRow, newCol, originalColor, borderList);
                    }
                    sameColorNeighbour++;
                }
            }
        }

        if (sameColorNeighbour < 4) { // it's a border
            borderList.add(new int[]{row, col});
        }
    }
}
