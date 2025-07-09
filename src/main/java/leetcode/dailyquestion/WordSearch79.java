package leetcode.dailyquestion;

import java.util.ArrayDeque;
import java.util.Queue;

public class WordSearch79 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, "SEE"));
        // Output: true
    }

    public static boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        char ch = word.charAt(0);
        int wordIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == ch && !vis[i][j]) {
                    boolean found = dfs(board, word, wordIndex, i, j, vis);
                    if(found){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int wordIndex, int i, int j, boolean[][] vis) {

        if (wordIndex == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j] || board[i][j] != word.charAt(wordIndex)) {
            return false;
        }

        vis[i][j] = true;

        if (dfs(board, word, wordIndex + 1, i - 1, j, vis) ||
            dfs(board, word, wordIndex + 1, i + 1, j, vis) ||
            dfs(board, word, wordIndex + 1, i, j - 1, vis) ||
            dfs(board, word, wordIndex + 1, i, j + 1, vis)
        ) {
            return true;
        }

        vis[i][j] = false;
        return false;
    }
    /*
     while (!queue.isEmpty() && wordIndex < word.length()-1) {
            int size = queue.size();
            wordIndex++;
            for (int queueSize = 0; queueSize < size; queueSize++) {
                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];
                vis[i][j] = true;

                if (i > 0 && board[i - 1][j] == word.charAt(wordIndex) && !vis[i - 1][j]) {
                    queue.offer(new int[]{i - 1, j});
                }
                if (i < n - 1 && board[i + 1][j] == word.charAt(wordIndex) && !vis[i + 1][j]) {
                    queue.offer(new int[]{i + 1, j});
                }
                if (j > 0 && board[i][j - 1] == word.charAt(wordIndex) && !vis[i][j - 1]) {
                    queue.offer(new int[]{i, j - 1});
                }
                if (j < n - 1 && board[i][j + 1] == word.charAt(wordIndex) && !vis[i][j + 1]) {
                    queue.offer(new int[]{i, j + 1});
                }
            }
        }
        return wordIndex == word.length()-1;
     */
}
