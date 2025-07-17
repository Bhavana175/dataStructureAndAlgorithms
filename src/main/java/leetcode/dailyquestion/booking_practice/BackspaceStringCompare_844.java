package leetcode.dailyquestion.booking_practice;

import java.util.Stack;

public class BackspaceStringCompare_844 {
    public static void main(String[] args) {

    }
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (char ch : s.toCharArray()){
            if(ch == '#'){
                if(!s1.isEmpty()){
                    s1.pop();
                }
            }else s1.push(ch);
        }

        for (char ch : t.toCharArray()){
            if(ch == '#'){
                if(!s2.isEmpty()){
                    s2.pop();
                }
            }else s2.push(ch);
        }

        String res1 = "";
        String res2 = "";
        while (! s1.isEmpty()){
            res1 += s1.pop();
        }
        while (! s2.isEmpty()){
            res2 +=s2.pop();
        }

        return res1.equals(res2);
    }
}
