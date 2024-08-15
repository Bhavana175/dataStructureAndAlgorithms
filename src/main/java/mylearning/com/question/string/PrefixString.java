package mylearning.com.question.string;

public class PrefixString {

    public static void main(String[] args) {
        PrefixString obj = new PrefixString();
        String[] str = {"flow", "flow", "flow"};
        System.out.println(" output : " + obj.longestCommonPrefix(str));

    }

    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        outer:
        for (int charIndex = 0; charIndex < strs[0].length(); charIndex++) {
            for (int i = 0, j = 0; i < strs.length; i++) {

                if (charIndex < strs[i].length() &&
                        (strs[j].charAt(charIndex) == strs[i].charAt(charIndex))) {
                } else {
                    break outer;
                }
            }
            prefix = prefix + strs[0].charAt(charIndex);
        }
        return prefix;
    }

}
