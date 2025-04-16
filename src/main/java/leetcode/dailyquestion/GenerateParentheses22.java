package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        rec(0,0,n, output, "");
        return output;
    }

    private static void rec(int open, int close, int n, List<String> output, String curr){

        //base condition
        if(open==close && close == n){
            output.add(curr);
            return;
        }
        if(open<n){
            rec(open+1,close,n,output,curr+"(");
        }
        if(close<open){
            rec(open,close+1,n,output, curr+")");
        }
    }
}
