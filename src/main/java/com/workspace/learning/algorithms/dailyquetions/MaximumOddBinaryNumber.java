package com.workspace.learning.algorithms.dailyquetions;

import java.util.Arrays;

public class MaximumOddBinaryNumber {

    public static void main(String[] args) {
        String s = "01010";
        // Output: "001"
        MaximumOddBinaryNumber obj = new MaximumOddBinaryNumber();
        String output = obj.maximumOddBinaryNumber(s);
        System.out.println(" output  : "+output);
    }

    public String maximumOddBinaryNumber(String s) {

        int len= s.length();
        char [] chArray = new char[len];

        for(int i=0, j=len-2, start=0; i<len; i++){
            if(s.charAt(i)=='1' && chArray[len-1] == 0){
                chArray[len-1]= s.charAt(i);
            }else if (s.charAt(i)=='0'){
                chArray[j]=s.charAt(i);
                j--;
            }else {
                chArray[start]=s.charAt(i);
                start++;
            }

        }
    return  new String(chArray);
    }


}
