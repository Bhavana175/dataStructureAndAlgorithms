package com.workspace.learning.algorithms.dailyquetions;

public class TraverseMatrix {

    //https://leetcode.com/problems/word-search/solutions/4968380/easiest-approach/?envType=daily-question&envId=2024-04-03

    public static void main(String[] args) {
        TraverseMatrix obj = new TraverseMatrix();
        char[][] board=    {{'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}};
        String  word = "SEE";

        System.out.println( "output : "+obj.exist(board,word));
    }

    private boolean exist(char[][] board, String word) {

        int m = board.length;
        int n= board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean result = false;
        for (int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==word.charAt(0)){
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result) return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board,
                              String word,
                              boolean[][] visited,
                              int i, int j, int index) {

        if (index == word.length()) {
            return true;
        }

        if(i<0 || j<0 ||
                i>=board.length || j>=board[0].length ||
                board[i][j]!=word.charAt(index) ||
                visited[i][j] ){
            return false;
        }

        visited[i][j]=true;

        if(     backtrack(board, word, visited, i-1, j, index+1) ||
                backtrack(board, word, visited, i+1, j, index+1) ||
                backtrack(board, word, visited, i, j-1, index+1) ||
                backtrack(board, word, visited, i, j+1, index+1))
        {
            return true;

        }

        visited[i][j] = false;
        return false;

    }




/*    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean result = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result) return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length ||
                j < 0 || j >= board[0].length ||
                visited[i][j] ||
                board[i][j] != word.charAt(index)
        ) {
            return false;
        }

        visited[i][j] = true;

        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
                backtrack(board, word, visited, i - 1, j, index + 1) ||
                backtrack(board, word, visited, i, j + 1, index + 1) ||
                backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }*/
}
