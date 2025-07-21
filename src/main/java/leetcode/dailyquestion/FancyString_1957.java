package leetcode.dailyquestion;

public class FancyString_1957 {
    public static void main(String[] args) {
        System.out.println(makeFancyString("aaabaaaa"));
    }

    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0, i = 0, start =0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            start = i + 1;
            count = 0;
            sb.append(ch);
            if (start < s.length() && ch == s.charAt(start)) {
                while (start < s.length() && ch == s.charAt(start)) {
                    count++;
                    if (count < 2) sb.append(ch);
                    start++;
                }
                i = start;
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
