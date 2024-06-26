package com.workspace.learning.interviews.goldS.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupAnagram {

    /**
     * Instructions to candidate.
     *  1) Given a list of words, group them by anagrams
     *     Input: List of "cat", "dog", "god"
     *     Output: A Set of Sets of anagrams: {{'cat'}, {'dog', 'god'}}
     *  2) Run this code in the REPL to observe its behaviour. The
     *     execution entry point is main().
     *  3) Consider adding some additional tests in doTestsPass().
     *  4) Implement the AnagramSolution group() method correctly.
     *  5) If time permits, try to improve your implementation.
     */

    /**
     * A means for grouping words by anagram (same letters irrespective of order)
     */
    @FunctionalInterface
    interface AnagramSolution {
        Set<Set<String>> group(List<String> words);
    }

    /**
     * public static boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false
     */
    public static boolean doTestsPass(){
        // todo: implement more tests, please
        // feel free to make testing more elegant

        // given some words
        List<String> words = Arrays.asList("cat", "dog", "god", "cat");

        // todo : and a solution to the problem
        AnagramSolution sol = (list)->{

            HashMap<String, HashSet<String>> map = new HashMap<>();

            for (int i = 0; i < list.size(); i++) {
                char [] chArr = list.get(i).toCharArray();
                Arrays.sort(chArr);
                String sortedKey = Arrays.toString(chArr);
                HashSet<String> set = new HashSet<>();
                if(map.containsKey(sortedKey)){
                    set =map.get(sortedKey);
                }
                set.add(list.get(i));
                map.put(sortedKey,set);
            }
            return new HashSet<>(map.values());
        };

        // when grouped
        Set<Set<String>> grouped = sol.group(words);

        // we expect god and dog to be identified as anagrams, whilst cat isn't
        boolean result = true;
        result = result && grouped.contains(new HashSet<>(Arrays.asList("cat")));
        result = result && grouped.contains(new HashSet<>(Arrays.asList("dog", "god")));
        return result;
    };


    /**
     * Execution entry point.
     */
    public static void main(String[] args){
        if(doTestsPass()){
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }

    }

}
