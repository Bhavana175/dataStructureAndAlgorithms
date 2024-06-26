package com.workspace.learning.interviews.wanerbrospractice.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter {
    //https://leetcode.com/problems/island-perimeter/description/

    public static void main(String[] args) {

        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        //Output: 16
        //Explanation: The perimeter is the 16 yellow stripes in the image above.

        int output = islandPerimeter(grid);
        System.out.println("Perimeter  " + output);

    }

    public static int islandPerimeter(int[][] grid) {

        int perimeter =0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                // traverse and check for one
                // visit 4 direction if 0 add 1, if boundary add 1, if 1 do nothing
                if(grid[i][j] == 1){
                    // found 1

                    if(i+1 >= row || grid[i+1][j]==0){
                        perimeter +=1;
                    }
                    if(i-1<0 || grid[i-1][j]==0){
                        perimeter +=1;
                    }
                    if(j+1 >= col || grid[i][j+1]==0){
                        perimeter +=1;
                    }
                    if(j-1 <0 || grid[i][j-1]==0){
                        perimeter +=1;
                    }

                }

            }
        }

        return perimeter;
    }

}
