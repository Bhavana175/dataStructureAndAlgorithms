package mylearning.com.congnizant;

import java.util.Stack;
import java.util.stream.Stream;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString rev = new ReverseString();
        String s = rev.reverseWords("i.like.this.program.very.much");
        System.out.println(s);
    }
    String reverseWords(String S)
    {
        // code here
        String output ="";
        Stack<String> stack = new Stack<>();
      //  String str =S.replaceAll("\\."," ");
        Stream.of(S.split("\\.")).forEach(stack::push);

        output=stack.pop();
        while(!stack.isEmpty()){

            output = output+"."+stack.pop();
        }

        return output;

    }

}
