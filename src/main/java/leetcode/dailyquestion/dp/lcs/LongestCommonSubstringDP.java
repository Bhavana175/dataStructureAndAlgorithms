package leetcode.dailyquestion.dp.lcs;

public class LongestCommonSubstringDP {
    public static void main(String[] args) {
        String s1 = "abcdofnkandlf";
        String s2 = "ertrhtyabcd";
        System.out.println(longestCommonSubstring(s1,s2));
    }

    public static int longestCommonSubstring(String s1, String s2){
        int n= s1.length();
        int m = s2.length();
        int [][] t = new int[n+1][m+1];
        int maxLength = 0;

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if(i==0 || j==0){
                    t[i][j] =0;
                }
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1+t[i-1][j-1];
                    maxLength = Math.max(maxLength, t[i][j]);
                }else t[i][j] =0;
            }
        }
        return maxLength;
    }
}
