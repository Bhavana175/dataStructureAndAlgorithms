package leetcode.dailyquestion.dp.lcs;

public class LongestRepeatingSubSequence {
    public static void main(String[] args) {
        String s1 = "AABEBCDD";
        System.out.println(longestRepeatingSubSequence(s1));
    }

    private static int longestRepeatingSubSequence(String s1) {
        int n = s1.length();
        int [][] t = new int[n+1][n+1];

        //base condition n==0 t[i][j] =0

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j <n+1 ; j++) {
                if(s1.charAt(i-1) == s1.charAt(j-1) && i!=j){
                    t[i][j] = 1+ t[i-1][j-1];
                }else t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }

        return t[n][n];
    }
}
