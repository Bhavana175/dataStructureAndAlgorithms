package mylearning.com.question;

import java.util.Scanner;

public class LargestSubstrPalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int loop = 0; loop < num; loop++) {
            int length = getLargestSubstringPalindrome(sc.next());
            System.out.println("Largest palindrome length : " + length);
        }
    }

    private static int getLargestSubstringPalindrome(String str) {

        int maxLen = 0;
        int counter;
        // forgeeksskeegfor abcdefghmoom ismomkrmadamoksoammaos ismomkrma ismomkrsoosrmadamok
        System.out.println("\ninput : "+str);
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 2; j < str.length(); j++) {
                counter = 0;
                if (str.charAt(i) == str.charAt(j)) {
                    String str1 = str.substring(i, j + 1);
                    for (int k = 0; k < str1.length() / 2; k++) {
                        if (!(str1.charAt(k) == str1.charAt((str1.length() - 1) - k))) {
                            counter = 0;
                            break;
                        }
                        counter = str1.length();
                    }
                    if (maxLen < counter) {
                        maxLen = counter;
                        System.out.println("substring:  "+str1);
                    }
                }

            }

        }
        return maxLen;
    }

}
