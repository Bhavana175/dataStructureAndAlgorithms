package com.workspace.learning.datastructure.graph;

public class MaxAreaIsland {
    //https://leetcode.com/problems/max-area-of-island/description/

    public static void main(String[] args) {
       int [][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
     //   Output: 6

        System.out.println(maxAreaOfIsland(grid));

    }

    public static int maxAreaOfIsland(int[][] grid) {

        int maxArea =0;
        int n= grid.length, m= grid[0].length;
        boolean [][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(grid[i][j]==1 && !vis[i][j]){

                    maxArea = Math.max(maxArea, dfs(grid, vis, i, j));

                }

            }
        }

        return maxArea;
    }

    private static int dfs(int[][] grid, boolean[][] vis, int i, int j) {

        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length
                || (grid[i][j]==0 && !vis[i][j])){
            return 0;
        } else if (vis[i][j]) {
            return 0;
        }
        vis[i][j]=true;

        int a1 = dfs(grid,vis, i+1, j);
        int a2 = dfs(grid,vis, i-1, j);
        int a3 = dfs(grid,vis, i, j+1);
        int a4 = dfs(grid,vis, i, j-1);
        return 1+a1+a2+a3+a4;
    }
}
