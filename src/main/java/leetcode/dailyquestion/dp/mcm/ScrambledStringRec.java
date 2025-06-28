package leetcode.dailyquestion.dp.mcm;

public class ScrambledStringRec {
    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgtam";
        System.out.println(isScrambledString(s1,s2));
    }

    private static boolean isScrambledString(String s1, String s2) {

        if(s1.length()!=s2.length()){
            return false;
        }

        return solve(s1, s2);

    }

    private static boolean solve(String s1, String s2) {

        if(s1.compareTo(s2) == 0){ // same string
            return true;
        }
        if(s1.length()<=1){
            return false;
        }
        int n= s1.length();
        boolean flag = false;

        for (int i = 1; i <= n-1; i++) {
            if((solve(s1.substring(0,i), s2.substring(n-i, n)) && solve(s1.substring(i, n), s2.substring(0,n-i)))
            || (solve(s1.substring(0,i), s2.substring(0, i)) && solve(s1.substring(i, n), s2.substring(i,n)))){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
