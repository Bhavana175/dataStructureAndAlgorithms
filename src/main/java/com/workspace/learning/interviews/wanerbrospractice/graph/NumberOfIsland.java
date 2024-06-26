package com.workspace.learning.interviews.wanerbrospractice.graph;

import org.hibernate.result.Output;

import java.util.Stack;

public class NumberOfIsland {

    //https://leetcode.com/problems/number-of-islands/

    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        int output = numIslands(grid);
        System.out.println("Total Island : " + output);

    }

    public static int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];

        int countIsland = 0;
        Stack<int[]> stack = new Stack<>();

        //loop for grid, condition vis[][]==f and grid[][]== 1
        // start countIsland++; add in stack
        //!stack.isEmpty pop -> 4 direction vis==F grid ==1
        // ----> vis T grid ->stack

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (!vis[i][j] && grid[i][j] == '1') {
                    countIsland++;
                    stack.push(new int[]{i, j});

                    while (!stack.isEmpty()) {

                        int[] curr = stack.pop();
                        int index1 = curr[0], index2 = curr[1];

                        if (index1 - 1 >= 0 && !vis[index1 - 1][index2] && grid[index1 - 1][index2] == '1') {
                            vis[index1 - 1][index2] = true;
                            stack.push(new int[]{index1 - 1, index2});
                        }

                        if (index1 + 1 < row && !vis[index1 + 1][index2] && grid[index1 + 1][index2] == '1') {
                            vis[index1 + 1][index2] = true;
                            stack.push(new int[]{index1 + 1, index2});
                        }

                        if (index2 - 1 >= 0 && !vis[index1][index2 - 1] && grid[index1][index2 - 1] == '1') {
                            vis[index1][index2 - 1] = true;
                            stack.push(new int[]{index1, index2 - 1});
                        }

                        if (index2 + 1 < col && !vis[index1][index2 + 1] && grid[index1][index2 + 1] == '1') {
                            vis[index1][index2 + 1] = true;
                            stack.push(new int[]{index1, index2 + 1});
                        }

                    }

                }

            }
        }

        return countIsland;

    }
}
