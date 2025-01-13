package leetcode.dailyquestion;

import java.util.Stack;

public class canBeValid {
    // https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/

    public static void main(String[] args) {
        // String  s = "))()))";
        String s1 = "(()())";
        String locked = "111111";

        String s2 = "())()))()(()(((())(()()))))((((()())(())";
        String locked2 = "1011101100010001001011000000110010100101";

        canBeValid(s1, locked);
        canBeValidUsingStack(s2, locked2);
    }

    //this is faster
    public static boolean canBeValid(String s, String locked) {
        int n = locked.length();

        if (s.length() % 2 != 0) {
            return false;
        }

        int closedBal = 0;
        int openBal = 0;

        // closed Locked < open , open locked <closed true;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1' && s.charAt(i) == ')') {
                closedBal++;
            } else openBal++;
            if (closedBal > openBal) {
                return false;
            }
        }

        closedBal = 0;
        openBal = 0;

        for (int i = n-1; i >0; i--) {
            if (locked.charAt(i) == '1' && s.charAt(i) == '(') {
                openBal++;
            } else closedBal++;
            if (closedBal < openBal) {
                return false;
            }
        }

        return true;
    }

    public static boolean canBeValidUsingStack(String s, String locked) {

        int n = locked.length();

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Integer> stack = new Stack<>(); // store index for flexible position
        Stack<Integer> stackLocked = new Stack<>();

        // iterate
        for(int i=0; i< n; i++){

          char ch = s.charAt(i);
          char lock = locked.charAt(i);

          if(lock=='0'){
              stack.push(i);
          }else {
              if(ch==')'){
                  if(!stackLocked.isEmpty()){
                      stackLocked.pop();
                  }else if(! stack.isEmpty()){
                      stack.pop();
                  }else return false;
              }else {
                  stackLocked.push(i);
              }
          }
        }

        System.out.println(stack.size());
        System.out.println(stackLocked.size());

        while ((!stack.isEmpty() && ! stackLocked.isEmpty()) && stack.peek()> stackLocked.peek()){
            stack.pop() ;
            stackLocked.pop();
        }

        System.out.println(stack.size());
        System.out.println(stackLocked.size());

        return stackLocked.isEmpty();

    }


}
