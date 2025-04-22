package leetcode.dailyquestion;

import java.util.*;

public class PathAllCities {
    public static void main(String[] args) {
        List<String[]> flights1 = Arrays.asList(
                new String[]{"A", "B"},
                new String[]{"B", "C"},
                new String[]{"C", "D"}
        );

        List<String[]> flights2 = Arrays.asList(
                new String[]{"A", "B"},
                new String[]{"C", "D"}
        );

        System.out.println("Example 1:");
        findIfWeCanTravelAllCities(flights1); // A -> B -> C -> D

        System.out.println("\nExample 2:");
        findIfWeCanTravelAllCities(flights2); // NA
    }


    public static void findIfWeCanTravelAllCities(List<String[]> flights) {
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> allCities = new HashSet<>();

        // Build graph
        for (String[] flight : flights) {
            String from = flight[0];
            String to = flight[1];

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            allCities.add(from);
            allCities.add(to);
        }

        // Step 1: Pick a start city — ideally one with 0 in-degree
        Map<String, Integer> inDegree = new HashMap<>();
        for (String[] flight : flights) {
            inDegree.put(flight[1], inDegree.getOrDefault(flight[1], 0) + 1);
        }

        String start = null;
        for (String city : allCities) {
            if (!inDegree.containsKey(city)) {
                start = city;
                break;
            }
        }
        if (start == null) {
            // fallback to any city
            start = allCities.iterator().next();
        }

        // Step 2: DFS
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        dfs(graph, start, visited, path);

        if (visited.size() == allCities.size()) {
            System.out.println(String.join(" -> ", path));
        } else {
            System.out.println("NA");
        }
    }

    private static void dfs(Map<String, List<String>> graph, String current, Set<String> visited, List<String> path) {
        visited.add(current);
        path.add(current);

        for (String neighbor : graph.getOrDefault(current, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited, path);
            }
        }
    }

}


