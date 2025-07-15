package leetcode.dailyquestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidWord_3136 {
    public static void main(String[] args) {
        System.out.println(isValid("Ya$"));
    }

    public static boolean isValid(String word) {
        if (word.length() < 3) return false;

        Set<Character> vowels = new HashSet<>(Arrays.asList(
                'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char ch : word.toCharArray()) {
            if (Character.isDigit(ch)) {
                continue;
            } else if (Character.isLetter(ch)) {
                if (vowels.contains(ch)) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else {
                return false;  // Special character
            }
        }

        return hasVowel && hasConsonant;

    }
}
