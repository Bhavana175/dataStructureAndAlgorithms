package mylearning.com.interviewfreshworks1round;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        /*
            Arr[] = [4,5,2,25,26]

            Output =[5,25,25,26,-1]
            Arr[] = [13,7,6,12]
            Output : [-1,12,12,-1]
         */

        int [] arr = {4,5,2,25,26};
        int [] arr2 = {4,26,2,25,28};
        //TreeMap<Integer, List<Integer>> map =
        int [] output = getNextMaxElement(arr2);
        System.out.println(Arrays.toString(output));
    }

    private static int[] getNextMaxElement(int[] arr) {

        int nextMaxElement = Integer.MIN_VALUE;
        int len = arr.length;
        int [] output  = new int [len];

        /*
         Arr[] = [4,5,2,25,26]
                   [4,26,2,25,28]
                   [      25    28  -1]

         Output =[5,25,25,26,-1]
         */

        for (int i = len-1; i >= 0; i--) {

            if(i<len-1 && arr[i]< arr[i+1]){
                output[i] = arr[i+1];
                nextMaxElement =arr[i+1];
            }else if(arr[i]>nextMaxElement){
                output[i] = -1;
                nextMaxElement= arr[i];
            }else {
                output[i]= nextMaxElement;
            }

        }

        return output;

    }

}
