package leetcode.dailyquestion.dp.lcs;


public class LongestCommonSubsequenceStrMemo {

    public static int [][] t = new int[10][10];

    public static void main(String[] args) {
        String x ="abcdefgh";
        String y = "abcdytegh";
        System.out.println(findLongestCommonSubsequence(x,y));
    }
    public static int findLongestCommonSubsequence(String x, String y){
        int n = x.length();
        int m = y.length();
        for(int i=0; i<t.length; i++){
            for (int j = 0; j < t.length; j++) {
                t[i][j] =-1;
            }
        }
        return lcs(x,y,n,m);

    }

    private static int lcs(String x, String y, int n, int m) {
        if(n==0 || m==0){
            return 0;
        }
        if(t[n][m]!=-1){
            return t[n][m];
        }

        if(x.charAt(n-1) == y.charAt(m-1)){
            t[n][m]= 1+lcs(x,y, n-1, m-1);
            return t[n][m];
        }else  t[n][m]= Math.max(lcs(x,y, n, m-1),lcs(x,y, n-1, m));
        return t[n][m];

    }
    }
