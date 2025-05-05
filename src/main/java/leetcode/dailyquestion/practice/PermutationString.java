package leetcode.dailyquestion.practice;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {

    public static void main(String[] args) {

        String s = "ABC";
        System.out.println(new PermutationString().getAllPermutation(s));
    }

    public List<String> getAllPermutation(String s) {
        List<String> outputList = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        //"ABC" ->. ABC, ACB , BAC BCA, CBA CAB
        rec(sb, outputList, 0);
        return outputList;
    }

    private void rec(StringBuilder sb, List<String> outputList, int startIndex) {
        //base case
        if (startIndex == sb.length()) {
            outputList.add(sb.toString());
        }

        for (int i = startIndex; i < sb.length(); i++) {
            //swap i,startIndex
            swap(sb, i, startIndex);
            rec(sb, outputList, startIndex+1);
            swap(sb, i, startIndex);
        }

    }

    private void swap(StringBuilder sb, int i, int startIndex) {
        char temp = sb.charAt(startIndex);
        sb.setCharAt(startIndex, sb.charAt(i));
        sb.setCharAt(i, temp);
    }


}
