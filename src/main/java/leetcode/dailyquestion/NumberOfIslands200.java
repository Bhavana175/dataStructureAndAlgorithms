package leetcode.dailyquestion;

import com.workspace.learning.datastructure.graph.NumberOfIsland;

public class NumberOfIslands200 {

    public static void main(String[] args) {

      char [][]  grid = {
              {'1','1','0','0','0'},
              {'1','1','0','0','0'},
              {'0','0','1','0','0'},
              {'0','0','0','1','1'}
      };

        NumberOfIslands200 obj = new NumberOfIslands200();
        System.out.println(obj.numIslands(grid));
}


    public int numIslands(char[][] grid) {

        int count =0;
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] vis = new boolean[n][m];

        // start from land ='1'; dfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(grid, i,j,vis);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] vis) {

        if(0<=i && i<grid.length && j>=0 && j<grid[0].length && !vis[i][j] && grid[i][j]=='1'){
            vis[i][j]=true;
            dfs(grid, i+1, j, vis);
            dfs(grid, i-1, j, vis);
            dfs(grid, i, j+1, vis);
            dfs(grid, i, j-1, vis);
        }
    }
}
