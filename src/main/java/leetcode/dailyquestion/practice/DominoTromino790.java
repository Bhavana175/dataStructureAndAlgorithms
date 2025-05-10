package leetcode.dailyquestion.practice;

import java.util.ArrayList;

public class DominoTromino790 {

    public static void main(String[] args) {

        System.out.println(new DominoTromino790().numTilings(30));
    }
    public int numTilings(int n) {
        int mod = 1000000007;
        long [] arr = new long[n+3];
        arr[0]=1;
        arr[1]=1;
        arr[2]=2;
        arr[3]=5;

        for (int i = 4; i <=n; i++) {
            arr[i] = (arr[i-1]*2 + arr[i-3]) % mod;
        }

        return (int) arr[n];
    }
}
