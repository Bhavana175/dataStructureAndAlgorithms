package leetcode.dailyquestion;

public class UniquePaths62 {

    public static void main(String[] args) {
        int m = 3, n = 7;
       // Output: 28

        System.out.println(uniquePaths(m,n));
    }
    public static int uniquePaths(int m, int n) {

        int count =0;
        boolean [][] vis = new boolean[m][n];

       return dfs(0,0,vis, count);

    }

    private static int dfs(int i, int j, boolean[][] vis, int count) {
        if(i== vis.length-1 && j == vis[0].length-1){
            count++;
            return count;
        }
        int down =0;
        int right =0;
        if(i< vis.length && j<vis[0].length && !vis[i][j]) {
            vis[i][j]= true;
            down = dfs(i + 1, j, vis, count);
            right = dfs(i, j + 1, vis, count);
            vis[i][j] = false;
        }
        return down+right;
    }

    public static int uniquePathsRec(int m, int n) {

        int count =0;
        int [][] dp = new int[m][n];

return 0;

    }
}
