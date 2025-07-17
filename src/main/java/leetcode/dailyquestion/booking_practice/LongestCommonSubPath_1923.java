package leetcode.dailyquestion.booking_practice;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubPath_1923 {
    public static void main(String[] args) {
        int n = 5;
        int [][] paths = {{0,1,2,3,4},
                {2,3,4},
                {4,0,1,2,3}};

        System.out.println(longestCommonSubpath(n, paths));
    }

    public static int longestCommonSubpath(int n, int[][] paths) {

        int [] prevPath = paths[0];

        for (int index = 1; index < paths.length-1; index++) {
            int [] currPath = paths[index];
            int [][] t = new int[prevPath.length+1][currPath.length+1];

            //base condition n=0, m=0, maxlcs =0
            for (int i = 1; i < prevPath.length; i++) {
                for (int j = 1; j < currPath.length ; j++) {
                    if(prevPath[i-1] == currPath[j-1]){
                        t[i][j] = 1+t[i-1][j-1];
                    }else {
                        t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                    }
                }
            }

            //dp table created , now create integer
            List<Integer> resultLcs = new ArrayList<>();
            int i = prevPath.length;
            int j = currPath.length;
            while (i>0 && j>0){

                if (prevPath[i - 1] == currPath[j - 1]) {
                    resultLcs.add(prevPath[i-1]);
                    i--;
                    j--;
                }else if(t[i-1][j]>t[i][j-1]){
                    i--;
                }else j--;


            }

            prevPath = new int[resultLcs.size()];
            for (int k = 0; k < resultLcs.size(); k++) {
                prevPath[k] = resultLcs.get(k);
            }
        }

        return prevPath.length;

    }

}
