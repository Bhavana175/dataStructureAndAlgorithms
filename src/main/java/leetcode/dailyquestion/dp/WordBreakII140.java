package leetcode.dailyquestion.dp;

import java.util.*;

public class WordBreakII140 {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");

        System.out.println(wordBreak(s, wordDict));
        // Output: ["cats and dog","cat sand dog"]

    }

    public static List<String> wordBreak(String s, List<String> wordDict) {

        List<List<String>> list = new ArrayList<>();
        HashSet<String> wordDictSet = new HashSet<>(wordDict);

        for (int i = 0; i <= s.length(); i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {

                if (wordDictSet.contains(s.substring(j, i))) {

                    if (j == 0) {
                        list.get(i).add(s.substring(j, i));
                    } else if (!list.get(j).isEmpty()) {
                        for (String str : list.get(j)) {
                            list.get(i).add(str + " " + s.substring(j, i));
                        }
                    }
                }

            }
        }

        return list.get(s.length());
    }
}







        /*List<List<String>> dp = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordDict);

        for (int i = 0; i < s.length() + 1; i++) {
            dp.add(new ArrayList<>());
        }

        for(int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (wordSet.contains(s.substring(j, i))) {
                    if (j == 0) {
                        dp.get(i).add(s.substring(j, i));
                    } else if (dp.get(j).size() > 0) {
                        for (String sub : dp.get(j)) {
                            dp.get(i).add(sub + " " + s.substring(j, i));
                        }
                    }
                }
            }
        }
        return dp.get(s.length());
*/

