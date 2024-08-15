package mylearning.com.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {

      /*  boolean result = false;

        Map<Character,Integer> frequency = new HashMap<>();

        if(a.length() == b.length()){

            for(int i=0; i<a.length(); i++){

                if(frequency.containsKey(a.charAt(i))){
                    frequency.put(a.charAt(i), frequency.get(a.charAt(i))+1);
                }else {
                    frequency.put(a.charAt(i), 1);
                }
                if(frequency.containsKey(b.charAt(i))){
                    frequency.put(b.charAt(i), frequency.get(b.charAt(i))-1);
                }else {
                    frequency.put(b.charAt(i),1);
                }
            }
            int sum = 0;
            for (Character key : frequency.keySet()) {
                sum = sum+frequency.get(key);
            }
            if(sum == 0){
                result = true;
            }

        }
        return result;*/


        boolean flag = false;
        a = a.toLowerCase();
        b= b.toLowerCase();

        if(a.length() == b.length()){

            for(int i =0; i<a.length(); i++){
                flag = false;
                for(int j=0; j<b.length(); j++){

                    if(a.charAt(i)== b.charAt(j)){
                        b = b.substring(0, j)+ b.substring(j+1);
                        flag = true;
                        break;
                    }
                }if(!flag){
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        String a = "anagramm";
        String b = "marganaa";
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
