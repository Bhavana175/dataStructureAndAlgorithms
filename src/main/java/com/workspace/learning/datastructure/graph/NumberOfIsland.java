package com.workspace.learning.datastructure.graph;

public class NumberOfIsland {

    //https://leetcode.com/problems/number-of-islands/description/
    public static void main(String[] args) {

        char [][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        //Output: 3
        System.out.println(numIslands(grid));
    }
    public static  int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean [][] vis = new boolean[n][m];
        int island =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(!vis[i][j] && grid[i][j]=='1'){
                    island++;
                    dfs(grid, vis, i,j);
                }

            }
        }

        return island;
    }

    private static void dfs(char[][] grid, boolean[][] vis, int i, int j) {

        if(i>= grid.length || i<0
                || j>=grid[0].length || j<0
                ||grid[i][j] =='0' || vis[i][j]){
            return;
        }

        vis[i][j]= true;
        dfs(grid, vis, i+1, j);
        dfs(grid, vis, i-1, j);
        dfs(grid, vis, i, j+1);
        dfs(grid, vis, i, j-1);

    }
}
