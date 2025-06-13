package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumberMinRowMaxCol {
    public static void main(String[] args) {

      int [][]  matrix = {
              {3, 8, 8},
              {9, 15, 13},
              {15, 6, 17}
      };

        System.out.println(getLuckyNumbers(matrix));

    }
    public static List<Integer> getLuckyNumbers(int [][] matrix){

        //row min
        //col max

        List<Integer> result = new ArrayList<>();


        for (int i = 0; i < matrix.length; i++) {
            int minRow = matrix[i][0];
            int minCol = 0;
            boolean luckyNumber = true;
            for (int j = 1; j < matrix[0].length; j++) {
                if(minRow>matrix[i][j]){
                    minRow = matrix[i][j];
                    minCol= j;
                }
            }

            for(int k =0; k< matrix.length; k++){
                if(matrix[k][minCol] > minRow){
                    luckyNumber = false;
                    break;
                }
            }

            if(luckyNumber){
                result.add(minRow);
            }

        }

        return result;
    }
}
