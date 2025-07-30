package leetcode.dailyquestion.practice.amazon;

public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
      String []   strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] arr) {
        if (arr.length == 0) {
            return "";
        }
        int endPointer = arr[0].length();
        String prefix = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {

            while (arr[i + 1].indexOf(prefix) !=0) {
                endPointer--;
                prefix = prefix.substring(0, endPointer);
            }

        }

        return prefix;


    }


}
