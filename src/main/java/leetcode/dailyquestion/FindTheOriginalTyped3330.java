package leetcode.dailyquestion;

import java.util.HashMap;

public class FindTheOriginalTyped3330 {
    public static void main(String[] args) {
        System.out.println(possibleStringCount("abbcccc"));
    }
    public static int possibleStringCount(String word) {
        int count =1;
        for (int i = 0; i < word.length()-1; i++) {
            char ch = word.charAt(i);
            while (i< word.length()-1 && ch == word.charAt(i+1)){
                count++;
                i++;
            }
        }
        return count;
    }
}
