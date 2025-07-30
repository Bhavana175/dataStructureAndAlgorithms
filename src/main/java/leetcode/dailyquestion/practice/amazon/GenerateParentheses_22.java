package leetcode.dailyquestion.practice.amazon;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrack(n, 0, 0, "", list);
        return list;
    }

    private static void backTrack(int n, int open, int close, String curr, List<String> list) {
        if(close == n){
            list.add(curr);
        }
        if(open<n) backTrack(n, open+1, close, curr+"(", list);
        if(close<open) backTrack(n, open, close+1, curr+")", list);
    }
}
