package mylearning.com.question.string;

import java.util.Arrays;

public class CloseStrings {

    public static void main(String[] args) {
        CloseStrings obj = new CloseStrings();

        obj.closeStrings("abc", "cba");
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        //all small alphabets
        int[] arr1= new int[26];
        int[] arr2= new int[26];
        for(int i= 0; i< word1.length(); i++){
            arr1[word1.charAt(i)-'a']=  arr1[word1.charAt(i)-'a']+1;
            arr2[word2.charAt(i)-'a']=  arr2[word2.charAt(i)-'a']+1;
        }

        for(int j=0; j<26; j++){
            if((arr1[j]>0 && arr2[j]>0) || (arr1[j]==0 && arr2[j]==0)){
            }else return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int k=0; k<26; k++){
            if(arr1[k]!=arr2[k]){
                return false;
            }
        }


        return true;
    }

}
