package leetcode.dailyquestion.dp.lcs;

public class LongestCommonSubsequenceStrRec {
    public static void main(String[] args) {
        String x ="ubdefgh";
        String y = "abcdytegh";
        System.out.println(findLongestCommonSubsequence(x,y));
    }
    public static int findLongestCommonSubsequence(String x, String y){
        int n = x.length();
        int m = y.length();
        return  lcs(x,y,n,m);

    }

    private static int lcs(String x, String y, int n, int m) {
        //base condition
        if(n==0 || m==0){
            return 0;
        }
        if(x.charAt(n-1) == y.charAt(m-1)){
            return lcs(x,y,n-1, m-1)+1; // +1 as we found one element
        }else return Math.max(lcs(x,y,n, m-1), lcs(x,y,n-1, m));

    }
}
