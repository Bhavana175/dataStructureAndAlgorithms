package com.workspace.learning.interviews.wanerbrospractice.graph;

import java.util.Stack;

public class IslandMaxPerimeter {
    //https://leetcode.com/discuss/interview-question/1947780/Discovery-or-Phone-or-Maximum-perimeter-of-Island

    // multiple island

    public static void main(String[] args) {
        int[][] grid = new int[][]
                {{0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 1, 1, 0},
                        {0, 1, 0, 1, 1, 1, 0},
                        {0, 0, 1, 1, 1, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0}};

        //    Output: 9 (Island on the right)

        int output = islandPerimeterMax(grid);
        System.out.println(output);

    }

    public static int islandPerimeterMax(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxPerimeter = 0;
        Stack<int[]> stack = new Stack<>();
        boolean[][] vis = new boolean[row][col];

        //traverse the 2D array , if found grid[][]==1
        // 1 surrounded by 1 from all direction is island (-1)
        // found island now traverse dir1 vis=false add

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (grid[i][j] == 1) {
                    //check for island 1 in all 4 direction
                    if (!vis[i][j] && (i - 1 >= 0 && i + 1 < row) && (j - 1 >= 0 && j + 1 < col) &&
                            grid[i + 1][j] == 1 && grid[i - 1][j] == 1 &&
                            grid[i][j - 1] == 1 && grid[i][j + 1] == 1) {
                        // got island as i , j
                        // vis[i][j] = true;
                        System.out.println("index " + i + " " + j);
                        // put it in stack for traversal

                        stack.push(new int[]{i, j});

                        while (!stack.isEmpty()) {

                            int[] curr = stack.pop();

                            // if 1 and vis false add to stack
                            // edge boundary condition or 0 add perimeter

                            int index1 = curr[0], index2 = curr[1];
                            // 4 direction traverse

                            if (index1 - 1 < 0 || index1 + 1 > row || index2 - 1 < 0 || index2 + 1 > col) {
                                maxPerimeter += 1;
                            } else {

                                if(!vis[index1-1][index2] && grid[index1-1][index2]==1 ){
                                    stack.push(new int [] {index1-1, index2});
                                }else if( grid[index1-1][index2]==0){
                                    return 1;
                                }


                            }

                            vis[index1][index2] = true;

                        }
                    }
                }

            }
        }
        return maxPerimeter;
    }

    public int islandPerimeter(int[][] grid) {
        int max = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, perimeter(grid, r, c));
                }
            }
        }
        return max;
    }

    private int perimeter(int[][] grid, int r, int c) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length) {
            if (grid[r][c] == 0) {
                return 1; // edge
            }
            if (grid[r][c] == -1) {
                return 0; // seen
            }
            grid[r][c] = -1;
            int perim = 0;
            perim += perimeter(grid, r, c + 1);
            perim += perimeter(grid, r + 1, c);
            perim += perimeter(grid, r, c - 1);
            perim += perimeter(grid, r - 1, c);
            return perim;
        } else {
            return 1; // out of bounds is also an edge
        }
    }

}
