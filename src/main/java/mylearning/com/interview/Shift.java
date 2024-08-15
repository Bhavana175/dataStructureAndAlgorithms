package mylearning.com.interview;

import java.sql.SQLOutput;

public class Shift {

    /**
     * NICE
     * Implement an algorithm to rotate an array to the right by k steps.
     * input arr: {1 2 3 4 5 6 7}, k=3
     *  output : {5 6 7 1 2 3 4}
     *
     * for(){
     *    int temp ;
     *
     *
     * }
     *
     *
     * tempArr
     * start (index= k+1, arr.len-1)
     * {5,6,7,0,0,0,0}
     *
     * second(startindex = 0, k)
     * {5,6,7,1,2,0,0}
     *
     *
     * reverse the string
     *
     *
     * str="bhavana"
     * Char [] chArr = str.toCharArray();
     * str2="";
     * for(int i=str.length-1; i>=0; i--){
     *
     *     str2= str2+str.charAt(i)
     *
     * }
     *    * str="bhavana"
     *      *reverse(String str){
     *      *
     *      *     if(str!=){
     *      *
     *      *     }
     *      *  return   reverse(str);
     *      *
     */

    public static void main(String[] args) {
        String s = "bhavana";
        System.out.println(reverse(s.toCharArray(), 0));
        int[] arr = {1 ,2 ,3 ,4 ,5 ,6 ,7};
        int step = 3;
        shiftArrayByStep(arr, step);
    }

    private static void shiftArrayByStep(int [] arr, int step) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(i<step){
                System.out.print(arr[n+i-step]+" ");
            }else {
                System.out.print(arr[i-step]+" ");
            }

        }
    }

    public static String reverse(char[] arr, int i) {
        if (i == arr.length - 1) {
            return String.valueOf(arr[i]);
        }

        return reverse(arr, i + 1) + arr[i];
    }





}
