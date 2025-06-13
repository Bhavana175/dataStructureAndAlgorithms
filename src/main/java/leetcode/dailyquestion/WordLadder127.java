package leetcode.dailyquestion;

import java.util.*;

public class WordLadder127 {
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        int count = 0;
        HashMap<String, List<String>> graph = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        queue.offer(beginWord);

        createGraph(wordList, graph, beginWord);
        for (int i = 0; i < wordList.size(); i++) {
            createGraph(wordList, graph, wordList.get(i));
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            count++;

            for (int qi = 0; qi < size; qi++) {
                String curr = queue.poll();
                if (graph.containsKey(curr) && !graph.get(curr).isEmpty()) {
                    List<String> edges = graph.get(curr);
                    for (int i = 0; i < edges.size(); i++) {
                        if (set.add(edges.get(i))) {
                            if (!endWord.equalsIgnoreCase(edges.get(i))) {
                                queue.add(edges.get(i));
                            } else {
                                return ++count;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    private static void createGraph(List<String> wordList, HashMap<String, List<String>> graph, String str) {
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (str.length() == word.length()) {
                int count = 0;
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) != word.charAt(j)) {
                        count++;
                    }
                }
                if (count == 1) {
                    graph.computeIfAbsent(str, (k) -> new ArrayList<>()).add(word);
                }

            }
        }
    }
}
