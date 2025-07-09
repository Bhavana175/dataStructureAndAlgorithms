package leetcode.dailyquestion.dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak139 {
    public static void main(String[] args) {
       String s = "catsandog";
       List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
      //  Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
        System.out.println(wordBreak(s,wordDict));
       // Output: true
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
