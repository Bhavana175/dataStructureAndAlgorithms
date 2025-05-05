package leetcode.dailyquestion.practice;

public class NumberOfIsland {

    public static void main(String[] args) {

        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(new NumberOfIsland().numIslands(grid));

    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, vis, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] vis, int i, int j) {

        vis[i][j] = true;

        if (0 < i && !vis[i - 1][j] && grid[i - 1][j] == '1') {
            dfs(grid, vis, i - 1, j);
        }
        if (i < grid.length-1 && !vis[i + 1][j] && grid[i + 1][j] == '1') {
            dfs(grid, vis, i + 1, j);
        }
        if (0 < j && !vis[i][j - 1] && grid[i][j - 1] == '1') {
            dfs(grid, vis, i, j - 1);
        }
        if (j < grid[0].length-1 && !vis[i][j + 1] && grid[i][j + 1] == '1') {
            dfs(grid, vis, i, j + 1);
        }
    }
}
