package leetcode.dailyquestion.graph;

public class NumberOfIslands_200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));

    }

    public static int numIslands(char[][] grid) {

        int n = grid.length;;
        int m = grid[0].length;
        boolean [][] vis = new boolean[n][m];
        int count =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j, boolean[][] vis) {

        if(i>=0 && i< grid.length && j>=0 && j< grid[0].length && !vis[i][j] && grid[i][j] =='1'){
            vis[i][j] = true;
            dfs(grid, i+1, j, vis);
            dfs(grid, i-1, j, vis);
            dfs(grid, i, j+1, vis);
            dfs(grid, i, j-1, vis);
        }
    }
}
