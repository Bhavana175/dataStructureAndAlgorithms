package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.List;

public class AddSpaceString {
    public static void main(String[] args) {
        String s = "ABC";
        System.out.println(findAllCombination(s));
    }

    private static List<String> findAllCombination(String s) {

        List<String> list = new ArrayList<>();
        list.add(s);
        solve(s, 1, list, s.charAt(0)+"");
        return list;
    }

    private static void solve(String s, int i, List<String> list, String temp) {

        if(i == s.length()){
            list.add(temp);
            return;
        }

        char ch = s.charAt(i);
        // without space
        solve(s, i+1, list, temp+ch  );
        solve(s, i+1, list, temp+" "+ch);

    }
}
