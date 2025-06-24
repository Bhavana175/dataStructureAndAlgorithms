package leetcode.dailyquestion.dp.lcs;

public class ShortestCommonSuperSequenceDp {
    public static void main(String[] args) {
        String s1 = "geek";
        String s2 = "eke";
        //output geeke =>5 ;
        System.out.println(lengthOfShortestSuperString(s1, s2));
    }

    private static int lengthOfShortestSuperString(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int [][] t = new int[n+1][m+1];

        //base condition n==0 m==0 t[i][j] =0;

        for (int i = 1; i < n+1 ; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    t[i][j] = 1+ t[i-1][j-1];
                }else t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
            }
        }

        return (n+m -t[n][m]);
    }
}
