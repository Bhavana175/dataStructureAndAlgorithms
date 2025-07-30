package leetcode.dailyquestion.practice.amazon;

import java.util.*;

public class FatherChildren_K {
    public static void main(String[] args) {
        //  Map<String, List<String>) -> Map<Father, [Child1, Child2 ...ChildN]
        /*
        Aman is father of Bheem and Chetan
        Bheem is father of Dinesh
        Chetan is father of Eknath
         */
        HashMap<String, List<String>> childrenMap = new HashMap<>();
        childrenMap.put("Aman", Arrays.asList("Bheem", "Chetan"));
        childrenMap.put("Bheem", Arrays.asList("Dinesh"));
        childrenMap.put("Chetan", Arrays.asList("Eknath"));

        System.out.println(listGeneration(childrenMap));
    }

    private static List<List<String>> listGeneration(HashMap<String, List<String>> childrenMap) {

        List<List<String>> result = new ArrayList<>();
        HashMap<String, Integer> inDegree = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        // HashSet<String> total = new HashSet<>();

        for (String key : childrenMap.keySet()) {
            String parent = key;
            inDegree.putIfAbsent(parent, 0);
            for (String child : childrenMap.get(key)) {
                inDegree.put(child, inDegree.getOrDefault(child, 0) + 1);
            }
        }

        for (String parent : childrenMap.keySet()) {
            if (inDegree.get(parent) == 0) {
                queue.offer(parent);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> genList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String currGen = queue.poll();
                for (String nextGen : childrenMap.getOrDefault(currGen, new ArrayList<>())) {
                    inDegree.put(nextGen, inDegree.get(nextGen) - 1);
                    if (inDegree.get(nextGen) == 0) {
                        queue.offer(nextGen);
                    }
                }
                genList.add(currGen);
            }
            result.add(genList);
        }
        return result;
    }


}
