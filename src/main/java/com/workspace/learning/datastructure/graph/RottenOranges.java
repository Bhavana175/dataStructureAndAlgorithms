package com.workspace.learning.datastructure.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    //https://leetcode.com/problems/rotting-oranges/description/
    public static void main(String[] args) {
       int [][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int [][] grid2 = {{2,1,1},{0,1,1},{1,0,1}};
        int [][] grid3 ={{2,2,2,1,1}};
        int [][] grid4 = {{2,2},{1,1},{0,0},{2,0}};
      //  System.out.println(orangesRotting(grid));
      //  System.out.println(orangesRotting(grid2));
        System.out.println(orangesRotting(grid4));
    }

    public static int orangesRotting(int[][] grid) {

        //list of rotten oranges
        //bfs
        //queue contains rotten oranges , visited array to track oranges
        // time count

        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean [][] vis = new boolean[n][m];
        int time=-1;
        int freshCount =0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m; j++) {

                if(grid[i][j]==2){
                    queue.add(new int []{i,j});
                    vis[i][j]= true;
                }else if(grid[i][j]==0){
                    vis[i][j]= true;
                }else freshCount++;

            }
        }
        if(freshCount==0){
            return 0;
        }

        while (!queue.isEmpty()){

            int queueSize = queue.size();
            time++;

            for (int k = 0; k < queueSize; k++) {
                int [] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];


                if(i-1>=0 && !vis[i-1][j]){
                    freshCount--;
                    vis[i-1][j] = true;
                    queue.add(new int[]{i-1, j});

                }
                if(i+1<n && !vis[i+1][j]){
                    queue.add(new int[]{i+1, j});
                    vis[i+1][j] = true;
                    freshCount--;
                }
                if(j-1>=0 && !vis[i][j-1]){
                    queue.add(new int[]{i, j-1});
                    vis[i][j-1] = true;
                    freshCount--;
                }
                if(j+1<m && !vis[i][j+1]){
                    queue.add(new int[]{i, j+1});
                    vis[i][j+1] = true;
                    freshCount--;
                }

            }

        }


        if(freshCount>0){
            return -1;
        }

        return time;
    }
}
