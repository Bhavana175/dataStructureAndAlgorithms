package com.workspace.learning.algorithms.dailyquetions;

import java.util.HashSet;

public class SubString {

    public static void main(String[] args) {

        String s= "abcab";

        printAllSubstring(s);
        System.out.println();
        countAllSubstringRecursion(s);
        System.out.println();
        System.out.println(findSubstrings(s));

    }

    private static void printAllSubstring(String s) {

        //o(n^2)
        for(int i=0; i<s.length();i++){
            for (int j=i; j<s.length(); j++){
                if(s.charAt(i)==s.charAt(j)){
                    System.out.println(s.substring(i,j+1));
                }
            }
        }

    }

    private static void countAllSubstringRecursion(String s) {

        System.out.println(countSubstring(s, 0, s.length()-1, s.length()));
    }

    private static int countSubstring(String s, int i, int j, int length) {

        if (length == 1)
            return 1;
        if (length <= 0)
            return 0;
        //union formula A+B-AintersectionB for count
        int res = countSubstring(s,i,j-1, length-1)+
                countSubstring(s,i+1,j, length-1)-
                countSubstring(s,i+1,j-1, length-2);

        if(s.charAt(i)==s.charAt(j)){
            res++;
        }
        return res;
    }

    public static HashSet<String> findSubstrings(String input) {
        HashSet<String> result = new HashSet<>();
        findSubstrings(input, 0, input.length() - 1, result);
        return result;
    }

    private static void findSubstrings(String input, int start, int end, HashSet<String> result) {
        if (start > end) {
            return;
        }

        // Check if start and end characters are the same
        if (input.charAt(start) == input.charAt(end)) {
            result.add(input.substring(start, end + 1));
        }

        // Recur for next substring excluding the last character
        findSubstrings(input, start, end - 1, result);

        // Recur for next substring excluding the first character
        findSubstrings(input, start + 1, end, result);
    }

}
