package mylearning.com.question.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWinners {

    public static void main(String[] args) {

        int [][] matches= {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        FindWinners obj = new FindWinners();
        System.out.println("    "+obj.findWinners(matches));
    }
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> winnerLists= new ArrayList<>();
        HashMap<Integer, Integer> myMap= new HashMap<>();
        List<Integer> ans0 = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        for(int i=0; i<matches.length; i ++){
                if (myMap.containsKey(matches[i][0])) {
                    myMap.put(matches[i][0], myMap.get(matches[i][0]) + 0);
                } else myMap.put(matches[i][0], 0);
            if (myMap.containsKey(matches[i][1])) {
                myMap.put(matches[i][1], myMap.get(matches[i][1]) + 1);
            } else myMap.put(matches[i][1], 1);
        }

        for (Map.Entry entry:myMap.entrySet()
             ) {
            if(entry.getValue().equals(0)){
                ans0.add((Integer) entry.getKey());
            }
            if(entry.getValue().equals(1)){
                ans1.add((Integer) entry.getKey());
            }
        }
        Collections.sort(ans0);
        Collections.sort(ans1);
        winnerLists.add(0,ans0 );
        winnerLists.add(1,ans1);
        return winnerLists;
    }
}
