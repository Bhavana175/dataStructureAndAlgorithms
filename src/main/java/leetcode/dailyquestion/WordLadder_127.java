package leetcode.dailyquestion;

import java.util.*;

public class WordLadder_127 {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, List<String>> graph = new HashMap<>();
        HashSet<String> vis = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        int len = beginWord.length();

        if (!wordList.contains(endWord)) return 0;

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1, len);
                graph.computeIfAbsent(pattern, (k) -> new ArrayList<>()).add(word);
            }
        }

        queue.offer(beginWord);
        vis.add(beginWord);
        int pathCount = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            pathCount++;

            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();

                for (int j = 0; j < currWord.length(); j++) {
                    String pattern = currWord.substring(0, j) + "*" + currWord.substring(j + 1, len);

                    for (String nextWord : graph.getOrDefault(pattern, new ArrayList<>())) {
                        if (nextWord.equals(endWord)) {
                            return pathCount + 1;
                        }
                        if (!vis.contains(nextWord)) {
                            vis.add(nextWord);
                            queue.offer(nextWord);
                        }

                    }
                }
            }
        }
        return 0;
    }
}
