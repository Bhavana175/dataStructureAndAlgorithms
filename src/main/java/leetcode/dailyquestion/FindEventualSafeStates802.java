package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindEventualSafeStates802 {

    public static void main(String[] args) {

    }
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        List<Integer> result = new ArrayList<>();

        //topological sort to know the sequence


        for (int i = 0; i < n; i++) {
            if(graph[i].length==0){
                //outDegree zero , terminal node , safe node
                result.add(i);
            }
        }


        return result;
    }
}
