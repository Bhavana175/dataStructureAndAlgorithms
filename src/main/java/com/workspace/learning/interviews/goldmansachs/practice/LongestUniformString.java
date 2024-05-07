package com.workspace.learning.interviews.goldmansachs.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestUniformString {


    private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

    static int[] longestUniformSubstring(String input){
        int longestStart = -1;
        int longestLength = 0;
        int i = 1;
        int length = input.length();
        while(i<length) {
            int start = i-1;
            int count =1;
            while (i<length && input.charAt(i - 1) == input.charAt(i)) {
                i++;
                count++;
            }
            if(count>longestLength){
                longestStart=start;
                longestLength=count;
            }
            i++;
        }

        return new int[]{ longestStart, longestLength };
    }

    public static void main(String[] args) {
      //  testCases.put("", new int[]{-1, 0});
      //  testCases.put("10000111", new int[]{1, 4});
     //   testCases.put("aabbbbbCdAA", new int[]{2, 5});
        testCases.put("1000011010101110110100010010011111111", new int[]{29, 8});
        // todo: implement more tests, please
        // feel free to make testing more elegant

        boolean pass = true;
        for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
            int[] result = longestUniformSubstring(testCase.getKey());
            pass = pass && (Arrays.equals(result, testCase.getValue()));
        }
        if(pass){
            System.out.println("All tests pass!");
        } else {
            System.out.println("At least one failure! :( ");
        }
    }

}
