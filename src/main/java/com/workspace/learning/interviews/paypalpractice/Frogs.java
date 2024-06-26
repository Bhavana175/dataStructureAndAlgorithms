package com.workspace.learning.interviews.paypalpractice;

public class Frogs {

    public static void main(String[] args) {

        int leaves = 4;
        int[] frogs = {3, 2, 4};
        //output = 1 , 1 is not visited (number of leaves not visited )

        int output = findCountNotVisitedLeaves(leaves, frogs);
        System.out.println("output "+output);

    }

    private static int findCountNotVisitedLeaves(int leaves, int[] frogs) {
        int[] arr = new int[leaves];
        int count = 0;

        for (int i = 0; i < frogs.length; i++) {
            int path = 0;
            while (path < leaves) {
                path = path + frogs[i];
                if (path <= arr.length) {
                    arr[path - 1] = arr[path - 1] + 1;
                }
            }

        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                count++;
            }
        }

        return count;
    }

}
