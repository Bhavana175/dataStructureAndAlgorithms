package mylearning.com.question.arrays;

import java.util.Arrays;

public class Matrix {
   /* Given an n x n array of integers matrix, return the minimum sum
    of any falling path through matrix.

    A falling path starts at any element in the first row and chooses
    the element in the next row that is either directly below or diagonally
    left/right. Specifically, the next element from position (row, col)
    will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
    Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
    Output: 13
    Explanation: There are two falling paths with a minimum sum as shown.
 */

    public static void main(String[] args) {
        Matrix obj= new Matrix();
        int [][] matrix= {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println("output : "+obj.minFallingPathSum(matrix));
    }
   public int minFallingPathSum(int[][] matrix) {
        int[] sumArr= new int[matrix.length];
        int minVal=0, n=matrix.length;

        outer: for(int  colNext=0; colNext< matrix.length; colNext++ ){
            sumArr[colNext]=matrix[0][colNext];
            inner: for(int row=0, col=colNext; row< matrix.length-1; row++) {
                minVal = matrix[row + 1][col];

                if (col + 1 < n && minVal > matrix[row + 1][col + 1]) {
                    minVal = matrix[row + 1][col + 1];
                    col= col+1;
                }
                if (col >= 1 && minVal > matrix[row + 1][col - 1]) {
                    minVal = matrix[row + 1][col - 1];
                    col=col-1;
                }

                sumArr[colNext] = sumArr[colNext]+ minVal;
            }
        }

       Arrays.sort(sumArr);
       return sumArr[0];
    }
}
