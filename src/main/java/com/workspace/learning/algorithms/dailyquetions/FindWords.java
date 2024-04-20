package com.workspace.learning.algorithms.dailyquetions;

import java.util.ArrayList;
import java.util.List;

public class FindWords {
    //https://leetcode.com/problems/word-search-ii/description/

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        // Output: ['eat','oath']

        List<String> output = findWords(board, words);

        System.out.println(output);

    }

    private static List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;

        for (int k = 0; k < words.length; k++) {
            boolean[][] visited = new boolean[m][n];
            boolean result = false;
            outer:
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == words[k].charAt(0)) {
                        result = backTrack(board, words[k], visited, i, j, 0);
                        if (result) {
                            list.add(words[k]);
                            break outer;
                        }
                    }
                }
            }
        }
        return list;
    }

    private static boolean backTrack(char[][] board,
                                     String word,
                                     boolean[][] visited,
                                     int i, int j,
                                     int index) {
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

        if (backTrack(board, word, visited, i + 1, j, index + 1) ||
                backTrack(board, word, visited, i - 1, j, index + 1) ||
                backTrack(board, word, visited, i, j + 1, index + 1) ||
                backTrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

}
