package leetcode.dailyquestion.practice.amazon;

import java.util.*;

public class Valid_k {
    public static void main(String[] args) {
        String[] people = { "A>B",  "B>C", "A>C" } ;
        System.out.println(isValid(people));
    }

    private static boolean isValid(String[] people) {

        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashSet<Character> peopleSet = new HashSet<>();
        HashMap<Character,Integer> inDegree = new HashMap<>();
        Queue<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < people.length; i++) {
            char taller = people[i].charAt(0);
            char shorter = people[i].charAt(2);

            graph.computeIfAbsent(taller, (k)->new ArrayList<>()).add(shorter);
            peopleSet.add(taller);
            peopleSet.add(shorter);

            inDegree.put(shorter, inDegree.getOrDefault(shorter,0)+1);
            inDegree.putIfAbsent(taller, 0);
        }

        for (Character ch : peopleSet){
            if(inDegree.get(ch) == 0){
                queue.offer(ch);
            }
        }
        int processedCount = 0;
        while (!queue.isEmpty()){

            char curr = queue.poll();
            processedCount++;
            if(graph.containsKey(curr)){
                for (int i = 0; i < graph.get(curr).size(); i++) {
                    char nei = graph.get(curr).get(i);
                    inDegree.put(nei, inDegree.get(nei)-1);
                    if(inDegree.get(nei)==0){
                        queue.offer(nei);
                    }
                }
            }
        }

        return processedCount == peopleSet.size();
    }
}
