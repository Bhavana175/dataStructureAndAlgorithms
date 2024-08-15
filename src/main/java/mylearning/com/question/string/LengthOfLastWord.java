package mylearning.com.question.string;

public class LengthOfLastWord {

/*  Given a string s consisting of words and spaces,
    return the length of the last word in the string.
    A word is a maximal substring consisting of non-space characters only.
    Example 1:
    Input: s = "Hello World"
    Output: 5
    Explanation: The last word is "World" with length 5.*/

    public static void main(String[] args) {

        LengthOfLastWord obj = new LengthOfLastWord();
        System.out.println("output :"
                + obj.lengthOfLastWord(" abscbbb  aaa  f ff   fffferttt    "));

    }

    public int lengthOfLastWord(String s) {
        //TWO WAYS

        //  String[] stringArray = s.split(" ");
        //  return stringArray[stringArray.length - 1].length();

        String str = s.trim();//removed spaces from start and last
        return str.substring(str.lastIndexOf(' ') + 1).length();
    }

}
