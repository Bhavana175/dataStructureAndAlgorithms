package mylearning.com.interviewLtts;

import java.util.HashMap;
import java.util.Map;

public class Round2 {

    public static void main(String[] args) {
    }
    /*
    Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
    Output: 1
    Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
    Output: 2
    +1 , -1 =0

     */
    public int countWords(String[] words1, String[] words2) {

        HashMap<String, Integer> map = new HashMap<>();
        int count =0;

        for(int i=0; i<words1.length; i++){
            map.put(words1[i], map.getOrDefault(words1[i], 0)+1);
        }
        for(int i=0; i<words2.length; i++){
            map.put(words2[i], map.getOrDefault(words2[i], 0)-1);
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()
             ) {
            if(entry.getValue()==0){
                count++;
            }
        }
        return count;
    }


    /*



find the winner , return boolean,

str= "BBBBNNNBBNN";
output = B

public char findTheWinner(String str){

	if(str ==null){
	return 'a';
	}
	if(str.length ==1){
	return str.charAt(0);
	}

	int countB =0;
	int countN =0;

	for(int i=0; i<str.length(); i++){

	if(str.charAt(i)=='B'){
		countB++;
	}else if(str.charAt(i)=='N'){
		countN++;
	}

	}

	if(countB>countN){
	return 'B'
	}



}

     */
}
