package com.workspace.learning.interviews.goldmansachs.practice;

public class PascalTriangle {

    /**
     *
     * ==  Instructions ==
     *   The below pattern of numbers are called Pascals Triangle.
     *  Pascals Triangle exhibits the following behaviour:
     *  The first and last numbers of each row in the triangle are 1
     *  Each number in the triangle is the sum of the two numbers above it.
     *  Example:
     *               1
     *              1 1
     *             1 2 1
     *            1 3 3 1
     *           1 4 6 4 1
     *         1 5 10 10 5 1
     *        1 6 15 20 15 6 1
     *  Please Complete the 'pascal' function below so that given a
     *  col and a row it will return the value in that positon.
     *  Example, pascal(1,2) should return 2
     *
     **/
    public void doTestsPass(){
        System.out.println(PascalTriangle.pascal(0,0) ==  1);
        System.out.println(PascalTriangle.pascal(1,2) ==  2);
        System.out.println(PascalTriangle.pascal(5,6) ==  6);
        System.out.println(PascalTriangle.pascal(4,8) ==  70);
        System.out.println(PascalTriangle.pascal(6,6) ==  1);
    }

    public static  int pascal(int col, int row){
        if (col == 0 || col == row) {
            return 1;
        } else {
            return pascal(col - 1, row - 1) + pascal(col, row - 1);
        }
    }

    public static void printPascalTriangle(int numRows){

/*        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print(pascal(col, row) + " ");
            }
            System.out.println();
        }*/

        int space = numRows;

        for(int currentRow = 0; currentRow<numRows; currentRow++) {
            int i = space;
            int col = currentRow;
            while (i>= 0) {
                System.out.print(" ");
                i--;
            }
            while (col>-1){
                System.out.print(pascal(col,currentRow)+" ");
                col--;
            }
            System.out.println();
            space--;
        }

    }

    public static void main(String[] args) {
       PascalTriangle p = new PascalTriangle();
     //  p.doTestsPass();
       p.printPascalTriangle(4);
    }

}
