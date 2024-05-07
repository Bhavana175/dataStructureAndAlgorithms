package com.workspace.learning.interviews.goldmansachs.practice;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import static org.junit.Assert.assertEquals;

/**
 * Implement a run length encoding function.
 * <p>
 * For a string input the function returns output encoded as follows:
 * "a"     -> "a1"
 * "aa"    -> "a2"
 * "aabbb" -> "a2b3"
 * "aabbbaa" -> "a2b3a2"
 * ""      -> ""
 */

public class EncodingFunction {

    public static void main(String[] args) throws InterruptedException {
       EncodingFunction e =new EncodingFunction();
       e.doTestsPass();
    }

    public static String rle(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length() ; i++) {
            int count = 1;
            while (i < input.length() - 1 &&
                    input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            String s=input.charAt(i)+""+ count;
            sb.append(s);
        }
        return sb.toString();
    }

    @Test
    public void doTestsPass() {
        assertEquals("a3", rle("aaa"));
        assertEquals("a3b2c1", rle("aaabbc"));
    }

}
