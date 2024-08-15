package mylearning.com.question.string;

public class HalvesAreAlike {

    public static void main(String[] args) {

      /*  You are given a string s of even length. Split this string into two
        halves of equal lengths, and let a be the first half and b be the second half.
        Two strings are alike if they have the same number of vowels
                ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
                Notice that s contains uppercase and lowercase letters.
                Return true if a and b are alike. Otherwise, return false.*/

        HalvesAreAlike obj = new HalvesAreAlike();
        System.out.println("  halvesAreAlike  : " + obj.halvesAreAlike("baooEk"));

    }

    public boolean halvesAreAlike(String s) {
        int len = s.length() / 2;
        String vowelStr = "aeiouAEIOU";
        String str1 = s.substring(0, len);
        String str2 = s.substring(len);
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < len; i++) {
            if (vowelStr.indexOf(str1.charAt(i)) != -1) {
                count1++;
            }
            if (vowelStr.indexOf(str2.charAt(i)) != -1) {
                count2++;
            }
        }

        return count1 == count2;
    }

    //copied from leetcode::::
    public boolean halvesAreAlikeFaster(String s) {
        int mid = s.length() / 2;
        String firstHalf = s.substring(0, mid);
        String secondHalf = s.substring(mid);

        int countFirst = countVowels(firstHalf);
        int countSecond = countVowels(secondHalf);

        return countFirst == countSecond;
    }

    private int countVowels(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

}
