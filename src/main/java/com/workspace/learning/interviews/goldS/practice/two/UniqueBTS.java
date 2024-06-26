package com.workspace.learning.interviews.goldS.practice.two;

public class UniqueBTS {

    public static void main(String[] args) {

        //https://leetcode.com/problems/unique-binary-search-trees/description/
        int n=4;
        int numberOfTrees = findUniqueBTS(4);
        System.out.println(n +" Number Of Unique BTS Trees "+numberOfTrees);

    }

    private static int findUniqueBTS(int n) {

        int [] arr = new int [n+1];
        arr[0]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                arr[i]+= arr[j]* arr[i-1-j];
                System.out.println(arr[i]);
            }

        }

        return  arr[n];
    }

}
