package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LetterCombinationOfPhoneNum_17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if(digits==null || digits.length() ==0){
            return  res;
        }

        HashMap<Character, String> digitMap = new HashMap<>();
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");

        backTrack(digits, 0, new StringBuilder(), digitMap, res);

        return  res;
    }

    private static void backTrack(String digits, int i, StringBuilder sb, HashMap<Character, String> digitMap, List<String> res) {

        if(i == digits.length()){
            res.add(sb.toString());
            return;
        }

        String str = digitMap.get(digits.charAt(i));

        for (char ch : str.toCharArray()){
            sb.append(ch);
            backTrack(digits, i+1, sb, digitMap, res);
            sb.deleteCharAt(sb.length()-1);
        }


    }

}
