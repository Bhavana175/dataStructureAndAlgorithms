package leetcode.dailyquestion;

public class FindTheKthCharacter_3304 {
    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
    }

    public static char kthCharacter(int k) {

        String word = "a";
        if (word.length() == k) return 'a';
        int len = word.length();

        while (len < k) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < len && len < k; i++) {
                char ch = (char) (word.charAt(i) + 1);
                next.append(ch);
            }
            word = word + "" + next.toString();
            System.out.println(word);
            len = word.length();
        }
        return word.charAt(k-1);
    }
}