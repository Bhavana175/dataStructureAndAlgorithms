package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfGivenString {

    public static void main(String[] args) {
        String  s = "ABC";
        System.out.println(new PermutationOfGivenString().findAllPermutation(s));
       // Output: “ABC”, “ACB”, “BAC”, “BCA”, “CAB”, “CBA”
    }

    public List<String> findAllPermutation(String s){

        //int n= s.length();
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);

        // swap character , fix one and swap again
        recursion(0, sb, res);
        return res;
    }

    private void recursion(int index, StringBuilder sb, List<String> res) {

        //base case
        if(index==sb.length()){
            res.add(sb.toString());
        }

        for (int i = index; i < sb.length(); i++) {
            swap(sb, index, i);
            recursion(index + 1, sb, res);
            swap(sb, index, i);
        }
    }

    // Swap characters at positions i and j
    static void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }
}
