package com.workspace.learning.algorithms.dailyquetions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class MaximalRectangle {

    //https://leetcode.com/problems/maximal-rectangle/description/?envType=daily-question&envId=2024-04-13

    public static void main(String[] args) {
        char [][] matrix = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        };
        MaximalRectangle obj = new MaximalRectangle();
      //  int area  = obj.maximalRectangle(matrix);
        int area2  = obj.maximalRectangle1ms(matrix);

        System.out.println(area2);
    }
    public int maximalRectangleMySolution(char[][] matrix) {
        int maxArea =0;
        int m= matrix.length;
        int n= matrix[0].length;
        boolean [][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j =0; j<n; j++){
                if(matrix[i][j] == 1) {
                    maxArea = backTrack(matrix, visited, i, j);
                }
            }
        }

        return maxArea;

    }

    private int backTrack(char[][] matrix, boolean[][] visited, int i, int j) {

/*        char [][] matrix = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        };*/

        if(i<0 || i> matrix.length ||
                j<0 ||  j>matrix[0].length ||
                matrix[i][j] != 1 ||
                visited[i][j])
        {
            return 0;
        }

        visited[i][j] = true;

        if( backTrack(matrix, visited, i-1, j) == 0 ||
                backTrack(matrix, visited, i+1, j) == 0 ||
                backTrack(matrix, visited, i, j-1) == 0 ||
                backTrack(matrix, visited, i, j+1) == 0
        ) {
            return 1;
        }

        visited[i][j] = false;
        return 0;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int ans = 0;
        int[] hist = new int[matrix[0].length];

        for (char[] row : matrix) {
            for (int i = 0; i < row.length; ++i)
                hist[i] = row[i] == '0' ? 0 : hist[i] + 1;
            ans = Math.max(ans, largestRectangleArea(hist));
        }

        return ans;
    }

    private int largestRectangleArea(int[] heights) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= heights.length; ++i) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                final int h = heights[stack.pop()];
                final int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, h * w);
            }
            stack.push(i);
        }

        return ans;
    }

//-----------------------------------------------------------------------------------
    public int maximalRectangle1ms(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int[] leftBoundaries = new int[n];
        int[] rightBoundaries = new int[n];
        Arrays.fill(rightBoundaries, n);

        int maxRectangle = 0;

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n;

            updateHeightsAndLeftBoundaries(matrix[i], heights, leftBoundaries, left);

            updateRightBoundaries(matrix[i], rightBoundaries, right);

            maxRectangle = calculateMaxRectangle(heights, leftBoundaries, rightBoundaries, maxRectangle);
        }

        return maxRectangle;
    }

    private void updateHeightsAndLeftBoundaries(char[] row, int[] heights, int[] leftBoundaries, int left) {
        for (int j = 0; j < heights.length; j++) {
            if (row[j] == '1') {
                heights[j]++;
                leftBoundaries[j] = Math.max(leftBoundaries[j], left);
            } else {
                heights[j] = 0;
                leftBoundaries[j] = 0;
                left = j + 1;
            }
        }
    }

    private void updateRightBoundaries(char[] row, int[] rightBoundaries, int right) {
        for (int j = rightBoundaries.length - 1; j >= 0; j--) {
            if (row[j] == '1') {
                rightBoundaries[j] = Math.min(rightBoundaries[j], right);
            } else {
                rightBoundaries[j] = right;
                right = j;
            }
        }
    }

    private int calculateMaxRectangle(int[] heights, int[] leftBoundaries, int[] rightBoundaries, int maxRectangle) {
        for (int j = 0; j < heights.length; j++) {
            int width = rightBoundaries[j] - leftBoundaries[j];
            int area = heights[j] * width;
            maxRectangle = Math.max(maxRectangle, area);
        }
        return maxRectangle;
    }


}
