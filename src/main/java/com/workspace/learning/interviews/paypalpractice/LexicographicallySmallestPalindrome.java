package com.workspace.learning.interviews.paypalpractice;

public class LexicographicallySmallestPalindrome {
//https://leetcode.com/problems/lexicographically-smallest-palindrome/description/

    /* Input: s = "abcd"
     Output: "abba"
     Explanation: The minimum number of operations to make "abcd" a
      palindrome is 2, and the lexicographically smallest palindrome string
      we can get by modifying two characters is "abba".
     Example 3:

     Input: s = "seven"
     Output: "neven"
     Explanation: The minimum number of operations to make "seven" a palindrome is 1, and the lexicographically smallest palindrome string we can get by modifying one character is "neven".
 */
    public static void main(String[] args) {

        String input = "azzzbbb";
        //Output: "abba"
        String output = makeLexPalindrome(input);
        System.out.println("input : "+input);
        System.out.println("output : "+output);

      //  Output: "neven"

        String input1 = "seven";
        //Output: "abba"
        String output1 = makeLexPalindrome(input1);
        System.out.println("input : "+input1);
        System.out.println("output : "+output1);
    }

    private static String makeLexPalindrome(String input) {

        char[] arr = input.toCharArray();
        int len = arr.length;

        for (int i = 0; i < arr.length / 2; i++) {

            if( arr[i] !=  arr[len-1-i] ){

                if( arr[i] > arr[len-1-i]){
                    arr[i] = arr[len-1-i];
                }else {
                    arr[len - 1 - i] = arr[i];
                }

            }
        }

        return new String(arr);
    }
}
