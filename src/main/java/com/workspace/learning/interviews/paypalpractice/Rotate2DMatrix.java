package com.workspace.learning.interviews.paypalpractice;

import java.util.Arrays;
import java.util.List;

public class Rotate2DMatrix {
    //https://leetcode.com/problems/rotate-image/description/

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // Output: [[7,4,1],[8,5,2],[9,6,3]]

        rotate(matrix);

    }

    public static void rotate(int[][] matrix) {

        //first replace ij-> ji than reverse for each row
        for (int i = 0; i < matrix.length; i++) {

            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse matrix for each row
        for (int i = 0; i < matrix.length; i++) {
            int len = matrix[0].length - 1;
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len];
                matrix[i][len] = temp;
                len--;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

}
