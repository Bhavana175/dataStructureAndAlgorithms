package leetcode.dailyquestion;

public class PalindromeK {

    //https://leetcode.com/problems/construct-k-palindrome-strings/description/?envType=daily-question&envId=2025-01-14

    public static void main(String[] args) {

        System.out.println(canConstruct("true", 4));

    }

    public static boolean canConstruct(String s, int k) {

        int oddCount=0;
        if(s.length()< k) return false;

        int [] freq = new int [26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(freq[i]==0) continue;
            if(freq[i]%2!=0){
                oddCount++;
            }

        }

        return oddCount<=k;


    }

}
