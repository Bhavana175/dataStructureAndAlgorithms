package com.workspace.learning.interviews.paypalpractice;

import java.util.Arrays;

public class MinPathSum {
    // https://leetcode.com/problems/minimum-path-sum/description/

    /*
    Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
    Output: 7
    Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     */

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int output = minPathSum(grid);
        System.out.println(output);
    }

    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] sum = new int[n][m];
        for(int i=0; i<sum.length; i++){
            Arrays.fill(sum[i], -1);
        }

        return traverse(grid, sum, 0, 0);
    }

    private static int traverse(int[][] grid, int[][] sum, int i1, int i2) {

        if(i1 >= grid.length || i2 >= grid[0].length)
            return Integer.MAX_VALUE;


        if (i1 == grid.length - 1 && i2 == grid[0].length - 1) {
            return grid[i1][i2];
        }

        if(sum[i1][i2] != -1){
            return sum[i1][i2];
        }

        sum[i1][i2] = grid[i1][i2] +
                Math.min(traverse(grid, sum, i1 + 1, i2),
                        traverse(grid, sum, i1, i2 + 1));

        return sum[i1][i2];
    }
}
