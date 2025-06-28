package leetcode.dailyquestion.dp.mcm;

public class EvaluateExpression {
    public static void main(String[] args) {
        String s = "T|T&F^T";
        //number of ways to result an  expression as true
        // ans 4;
        System.out.println(countNumberOfWays(s));
    }

    private static int countNumberOfWays(String s) {

        int i=0;
        int j = s.length()-1;

        return solve(s, i, j, true);

    }

    private static int solve(String s, int i, int j, boolean isTrue) {

        if(i>j){
            return 0;
        }
        if(i==j){
            if(isTrue == (s.charAt(i)=='T')){
                return 1;
            }else return 0;
        }
        int ans =0;

        for (int k = i+1; k <= j-1; k=k+2) {

            int lt = solve(s,i,k-1, true);
            int lf = solve(s,i,k-1, false);
            int rt = solve(s,k+1,j, true);
            int rf = solve(s,k+1,j, false);

            if(s.charAt(k)=='&'){
                if(isTrue){
                    ans+= lt*rt;
                }else ans+= (lt*rf)+(lf*rt)+(lf*rf);
            }
            if(s.charAt(k)=='|'){
                if(isTrue){
                    ans += (lt*rt) + (lf*rt) +(lt*rf);
                }else ans += lf*rf;
            }
            if(s.charAt(k)=='^'){
                if(isTrue){
                    ans += (lf*rt) + (lt*rf);
                }else ans += (lt*rt) + (lf*rf);
            }
        }

        return ans;
    }
}
