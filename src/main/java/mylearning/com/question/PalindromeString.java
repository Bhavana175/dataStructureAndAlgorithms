package mylearning.com.question;

import java.util.Scanner;

public class PalindromeString {

    public static void main(String[] args) {
        // check given String is palindrome or not
        Scanner sc = new Scanner(System.in);
        System.out.println("provide count of str input first and thn str :");
        int n = sc.nextInt();
        for (int loop = 0; loop < n; loop++) {
            isPalindrome(sc.next());
        }
    }

    private static void isPalindrome(String str) {

        str = str.toUpperCase();
        boolean flag = true;
        int j = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++) {
            if (!(str.charAt(i) == str.charAt(j - i))) {
                flag = false;
                break;
            }
        }

        System.out.println("Is " + str + " palindrome : " + flag);

    }

}
