package leetcode.dailyquestion;

import java.util.*;
import java.util.stream.Stream;

public class PermutationOfStr {

    public static void main(String[] args) {

        String s = "ABC";
        System.out.println(new PermutationOfStr().findPermutations(s));
        System.out.println(new PermutationOfStr().findPermutations2(s));
        System.out.println("findPermutations(s)");
        System.out.println("Time complexity : O(N*N!)");
        System.out.println("Space complexity : O(N)");

    }

    public List<String> findPermutations(String s) {

        List<String> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        //len n , fix 1 -> 2-n , fix 1,2,-> 2-n till n and swap ,
        rec(sb, output, 0);
        return output;

    }

    private void rec(StringBuilder sb, List<String> output, int startIndex) {

        if (startIndex == sb.length()) {
            output.add(sb.toString());
            return;
        }

        for (int i = startIndex; i < sb.length(); i++) {
            // swap
            swap(sb, i, startIndex);
            rec(sb, output, startIndex + 1);
            // reset swap
            swap(sb, i, startIndex);
        }
    }

    private void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }


    //________________________________

    public List<String> findPermutations2(String s) {

        HashSet<Character> vis = new HashSet<>();
        List<String> ans = new ArrayList<>();
        StringBuilder pathBuilder = new StringBuilder();

        dfs( s,  vis, pathBuilder, ans);

        return ans;
    }

    private void dfs( String s,  HashSet<Character> vis, StringBuilder path, List<String> ans) {

        if (path.length() == s.length()) {
            ans.add(path.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if(vis.contains(s.charAt(i))) continue;
            vis.add(s.charAt(i));
            path.append(s.charAt(i));
            dfs(s, vis, path, ans);
            vis.remove(s.charAt(i));
            path.deleteCharAt(path.length()-1);
        }


    }
}
