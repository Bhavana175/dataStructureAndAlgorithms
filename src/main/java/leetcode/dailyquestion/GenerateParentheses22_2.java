package leetcode.dailyquestion;
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22_2 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        computeParenthesis(n, list ,0, 0, "");
        return list;

    }

    private static void computeParenthesis(int n, List<String> list, int open, int close , String curr) {

        if(open == n && open==close){
            list.add(curr);
        }

        if(open<n){
            computeParenthesis(n, list,open+1, close, curr+"(");
        }
        if(close<open){
            computeParenthesis(n, list,open, close+1, curr+")");
        }
    }
}
