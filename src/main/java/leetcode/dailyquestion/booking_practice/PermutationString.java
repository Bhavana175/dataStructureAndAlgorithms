package leetcode.dailyquestion.booking_practice;

import java.util.ArrayList;
import java.util.List;

public class PermutationString {
    public static void main(String[] args) {
        System.out.println(permutation("ABC"));
    }
    public static List<String> permutation(String str){

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean [] vis = new boolean[str.length()];
        rec(str, vis, result, sb);
        return result;
    }

    private static void rec(String str, boolean[] vis, List<String> result, StringBuilder sb) {

        if(sb.length() == str.length()){
            result.add(new String(sb.toString()));
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if(!vis[i]){
                vis[i] = true;
                sb.append(str.charAt(i));
                rec(str, vis, result, sb);
                vis[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }

        }
    }
}
