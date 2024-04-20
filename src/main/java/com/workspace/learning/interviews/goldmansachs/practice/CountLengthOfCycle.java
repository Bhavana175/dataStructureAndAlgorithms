package com.workspace.learning.interviews.goldmansachs.practice;

import java.util.HashMap;
import java.util.Map;

public class CountLengthOfCycle {

    /**
     * countLengthOfCycle(arr, startIndex)
     * <p>
     * You are given an integer array of size N.
     * Every element of the array is greater than or equal to 0.
     * Starting from arr[startIndex], follow each element to the index it points to.
     * Continue to do this until you find a cycle.
     * Return the length of the cycle. If no cycle is found return -1
     * <p>
     * Examples:
     * countLengthOfCycle([1, 0], 0) == 2
     * countLengthOfCycle([1, 2, 1], 1) == 3
     * <p>
     * cycle->a[start] i.e a[0] = 1 and a[1]=0  case 2:  a[a[x]]=x; a[0]=1,a[1]=2,a[2]=0 i.e start a[n]=start
     */
    public static int countLengthOfCycle(int[] arr, int startIndex) {
        //TODO: Implement solution

/*        Map<Integer, Integer> visited = new HashMap<>();
        int count = 1;
        int index = startIndex;
        while(!visited.containsKey(index)){
            if(arr[index] > arr.length) {
                return -1;
            }
            visited.put(index, count);
            count++;
            index = arr[index];
        }
        return count - visited.get(index);*/




        boolean[] visited = new boolean[arr.length];
        int currentIndex = startIndex;
        int count = 0;
        if(arr[currentIndex]>arr.length){return -1;}

        while (currentIndex >= 0 &&
                currentIndex < arr.length &&
                arr[currentIndex] < arr.length &&
                !visited[currentIndex]) {

            visited[currentIndex] = true;
            currentIndex = arr[currentIndex];
            count++;

        }
        if (currentIndex == startIndex) {
            return count;
        } else if (currentIndex< arr.length &&
                arr[currentIndex] < arr.length &&
                arr[arr[currentIndex]]< arr.length &&
                currentIndex == arr[arr[currentIndex]]) {
            return Math.abs(currentIndex - arr[currentIndex]) + 1;
        }

        return -1;
    }

    /**
     * boolean doTestsPass()
     * Returns true if all the tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        // TODO: implement some tests, please
        // we've included a trivial boilerplate

        boolean testsPassed = true;
        testsPassed &= countLengthOfCycle(new int[]{1, 0}, 0) == 2;
       testsPassed &= countLengthOfCycle(new int[]{1, 2, 0}, 0) == 3;
       testsPassed &= countLengthOfCycle(new int[]{1, 1}, 0) == 1;
          testsPassed &= countLengthOfCycle(new int[]{1, 3, 0, 1}, 0) == 3;
       testsPassed &= countLengthOfCycle(new int[]{7}, 0) == -1;
        testsPassed &= countLengthOfCycle(new int[]{1, 2, 4}, 0) == -1;

        if (testsPassed) {
            System.out.println("Test passed.");
            return true;
        } else {
            System.out.println("Test failed.");
            return false;
        }
    }

    public static void main(String[] args) {
        doTestsPass();
    }

}
