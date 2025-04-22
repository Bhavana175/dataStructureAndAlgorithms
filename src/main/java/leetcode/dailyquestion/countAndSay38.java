package leetcode.dailyquestion;

public class countAndSay38 {

    public static void main(String[] args) {

        System.out.println(countAndSay(4));
    }

    public static  String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String str= countAndSay(n-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <str.length();) {
            Character ch = str.charAt(i);
            int count =0;
            while (i<str.length() && ch == str.charAt(i)){
                count++;
                i++;
            }
            sb=sb.append(count).append(ch);
        }
        return sb.toString();
    }
}
