package com.workspace.learning.datastructure.graph;

public class IslandPerimeter {

    public static void main(String[] args) {
        //https://leetcode.com/problems/island-perimeter/description/

        int [][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        //Output: 16
        System.out.println(islandPerimeter(grid));

    }
    public static int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if(grid[i][j]==1){

                    int perimeter = dfs(grid, vis, i,j);
                    return perimeter;
                }
            }

        }
        return 0;
    }

    private static int dfs(int[][] grid, boolean[][] vis, int i, int j) {

        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length
        || (grid[i][j]==0 && !vis[i][j])){
            return 1;
        } else if (vis[i][j]) {
            return 0;
        }
        vis[i][j] = true;

        int p1 = dfs(grid, vis, i+1, j);
        int p2 = dfs(grid, vis, i-1, j);
        int p3 = dfs(grid, vis, i, j+1);
        int p4 = dfs(grid, vis, i, j-1);

        int perimeter = p1+p2+p3+p4;
        return perimeter;
    }
}
