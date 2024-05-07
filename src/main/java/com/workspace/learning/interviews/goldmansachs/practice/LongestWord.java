package com.workspace.learning.interviews.goldmansachs.practice;

import java.util.ArrayList;
import java.util.Arrays;;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Instructions to candidate.
 * 1) Given  a string of letters and a dictionary, the function longestWord should
 * find the longest word or words in the dictionary that can be made from the letters
 * Input: letters = "oet", dictionary = {"to","toe","toes"}
 * Output: {"toe"}
 * Only lowercase letters will occur in the dictionary and the letters
 * The length of letters will be between 1 and 10 characters
 * The solution should work well for a dictionary of over 100,000 words
 * 2) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 3) Consider adding some additional tests in doTestsPass().
 * 4) Implement the longestWord() method correctly.
 * 5) If time permits, introduce '?' which can represent any letter.  "to?" could match to "toe", "ton" etc
 */

class Dictionary {

    private String[] entries;

    public Dictionary(String[] entries) {
        this.entries = entries;
    }

    public String[] getEntries() {
        return entries;
    }

    public boolean contains(String word) {
        return Arrays.asList(entries).contains(word);
    }
}

public class LongestWord {

    public static Set<String> longestWord(String letters, Dictionary dict) {

        HashMap<String, List<String>> map = new HashMap<>();
        String letterSorted = getSortedString(letters);
        Set<String> result = new HashSet<>();

        //arrange dict words in key value
        for (String word : dict.getEntries()
        ) {
            String key = getSortedString(word);
            List<String> list = new ArrayList<>();
            if (map.containsKey(key)) {
                list = map.get(key);
            }
            list.add(word);
            map.put(key, list);
        }

        HashSet<String> searchWordSet = new HashSet<>();
        searchWordSet.add(letterSorted);

        while (searchWordSet.size() > 0) {

            searchWordSet.stream()
                    .filter(s1 -> map.containsKey(s1))
                    .map(l -> {
                        return map.get(l).stream().collect(Collectors.toList());
                    }).forEach(l -> l.stream().forEach(e -> result.add(e)));

            if (result.size() > 0) {
                break;
            }
            searchWordSet = removeSingleLetter(searchWordSet);
        }
        return result;
    }

    private static HashSet<String> removeSingleLetter(HashSet<String> wordsSet) {
        HashSet<String> setOfWords = new HashSet<>();
        wordsSet.stream().forEach(w -> {
            if (w != null) {
                for (int i = 0; i < w.length(); i++) {
                    setOfWords.add(w.substring(0, i) + w.substring(i + 1, w.length()));
                }
            }
        });
        return setOfWords;
    }

    private static String getSortedString(String word) {
        return Stream.of(word.split("")).sorted().collect(Collectors.joining());
    }

    public static boolean doTestsPass() {
 /*       // Not bothering to test letters for null, empty string or non lower-case
        boolean result = testDroppingLetter(Arrays.asList("abc"), Arrays.asList("ab", "bc", "ac"));
        result = result && testDroppingLetter(Arrays.asList("abb"), Arrays.asList("ab", "bb"));
        result = result && testDroppingLetter(Arrays.asList("ab", "bb"), Arrays.asList("a", "b"));
        result = result && testDroppingLetter(Arrays.asList("a", "b"), Arrays.asList());*/

        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"});

        boolean result = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
        result = result && new HashSet<String>(Arrays.asList("toes", "dogs")).equals(longestWord("osetdg", dict));
        result = result && new HashSet<String>(Arrays.asList("doe", "toe", "dog", "god")).equals(longestWord("oetdg", dict));
        result = result && new HashSet<String>(Arrays.asList("book")).equals(longestWord("obokt", dict));
        result = result && new HashSet<String>(Arrays.asList("banana")).equals(longestWord("nanabaook", dict));
        result = result && new HashSet<String>().equals(longestWord("aeiou", dict));
        result = result && new HashSet<String>().equals(longestWord("a", dict));

        return result;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.err.println("There are test failures");
        }
    }
}
