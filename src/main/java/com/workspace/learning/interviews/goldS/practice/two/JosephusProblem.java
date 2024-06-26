package com.workspace.learning.interviews.goldS.practice.two;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

    //https://www.geeksforgeeks.org/josephus-problem/

    public static void main(String[] args) {

        int n = 7, k = 3;
        int output = findWinnerPosition(n, k);
        System.out.println(output);

        int n1 = 5, k1 = 2;
        int output1 = findWinnerPosition(n1, k1);
        System.out.println(output1);
    }

    private static int findWinnerPosition(int n, int k) {

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arrayList.add(i);
        }
        int start =0;
        while (1 < arrayList.size()) {

            start = (start+k-1)%arrayList.size();
            arrayList.remove(start);

        }

        return arrayList.get(0);
    }
}
