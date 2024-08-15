package mylearning.com.interviewepam22;

import java.util.ArrayList;

public class Solution {

    /*

The input is 2 strings representing integer decimal numbers with possible huge absolute value.
The task is to perform multiplication
without using BigDecimal or BigInteger from Java standard library.

Example 1:
    Input:
        -123456789
        1000
    Output:
        -123456789000

Example 2:
    Input:
        -5609814095670785987450101057461987365715718375
        -987654321234567898765432123456789
    Output:
        5540557132911841478857543165820141898332916971365359892859689227044277405797875

     */
    public static void main(String[] args) {

        String s1 = "5609814095670785987450101057461987365715718375";
        String s2 = "987654321234567898765432123456789";
        String output = multiplication(s1, s2);
        System.out.println(output);
    }

    private static String multiplication(String s1, String s2) {

        boolean isNegative = false;

        if(s1.indexOf("-")>=0 && s2.indexOf("-")>=0){
            s1 = s1.substring(1);
            s2 = s2.substring(1);
            isNegative= false;
        }else if(s1.indexOf("-")>=0){
            s1 = s1.substring(1);
            isNegative = true;
        }else if (s2.indexOf("-")>=0){
            s2 = s2.substring(1);
            isNegative = true;
        }


        // store multiplication output
        ArrayList<Integer> list = new ArrayList<>();
        int carry = 0;
        int currSize =0;

        StringBuilder sb = new StringBuilder();

        for (int j = s2.length() - 1; j >=0; j--) {
            for (int i = s1.length() - 1; i >= 0; i--) {
                int multiplication = Integer.parseInt(String.valueOf(s1.charAt(i)))
                        * Integer.parseInt (String.valueOf(s2.charAt(j)));
                int num = multiplication % 10 + carry;
                if(currSize==list.size() && list.size()!=0 && i== s1.length()-1){
                    num = num+list.get(currSize-1);
                    list.add(currSize-1, num);
                    list.remove(currSize);
                }else {
                list.add(num);
                }
                carry = multiplication / 10;
            }
            currSize = list.size();
        }
        if(isNegative){
            sb.append("-");
        }
        for (int i = list.size()-1; i >=0; i--) {
            sb.append(list.get(i));
        }

    return sb.toString();
    }

}
