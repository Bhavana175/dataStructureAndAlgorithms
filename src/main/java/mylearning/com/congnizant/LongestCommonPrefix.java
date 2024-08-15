package mylearning.com.congnizant;

public class LongestCommonPrefix {

/*
    Input: {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
    Output: “gee”

    Input: {“apple”, “ape”, “april”}
    Output: “ap”*/

    public static void main(String[] args) {
        String longestPrefix = getLongestPrefix(new String[]{"rgeeks", "mgeeksforgeeks", "qgeeks", "zgeek", "geezer"});
        System.out.println(longestPrefix);
    }

    public static String getLongestPrefix(String[] arr) {

        if (arr.length == 0) {
            return "not found";
        }

        String output = arr[0];

        for (int i = 1; i < arr.length; i++) {

            while(arr[i].indexOf(output) != 0){
                output = output.substring(0, output.length()-1);
                if(output.isEmpty()){
                    return "-1";
                }
            }

        }

        return output;
    }
}
