package mylearning.com.congnizant;

import java.util.HashMap;
import java.util.HashSet;

public class Isomorphic {
    // https://www.geeksforgeeks.org/check-if-two-given-strings-are-isomorphic-to-each-other/

/*    Input:  str1 = “aab”, str2 = “xxy”
    Output: True
    Explanation: ‘a’ is mapped to ‘x’ and ‘b’ is mapped to ‘y’.*/

    public static void main(String[] args) {

        boolean isISo = isomorphic("aab", "axy");
        System.out.println(isISo);
    }

    public static boolean isomorphic(String s1, String s2) {

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {

            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (set.contains(c2)) {
                    return false;
                }

                map.put(c1, c2);
                set.add(c2);
            }

        }

        return true;

    }
}
