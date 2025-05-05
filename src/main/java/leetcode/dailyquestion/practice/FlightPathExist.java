package leetcode.dailyquestion.practice;

import java.util.*;

public class FlightPathExist {

    public static void main(String[] args) {
        List<String[]> flights = Arrays.asList(
                new String[]{"A", "B"},
                new String[]{"B", "C"},
                new String[]{"C", "D"},
                new String[]{"C", "M"},
                new String[]{"Q", "M"}
        );

        String src = "A";
        System.out.println(isPathExistToCoverAllCities(flights, src));
    }

    private static boolean isPathExistToCoverAllCities(List<String[]> flights, String src) {

        //create graph
        HashMap<String, List<String>> adjList = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        HashSet<String> cities = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        for (int i = 0; i < flights.size(); i++) {
            adjList.computeIfAbsent(flights.get(i)[0], (k) -> new ArrayList<>()).add(flights.get(i)[1]);
            cities.add(flights.get(i)[0]);
            cities.add(flights.get(i)[1]);
        }

        queue.offer(src);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currCity = queue.poll();
                if (!visited.contains(currCity)) {
                    visited.add(currCity);
                    //visit all
                    if (adjList.containsKey(currCity)) {
                        List<String> neighbour = adjList.get(currCity);
                        for (int j = 0; j < neighbour.size(); j++) {
                            if (!visited.contains(neighbour.get(j))) {
                                queue.offer(neighbour.get(j));
                            }
                        }
                    }
                }
                if (visited.size() == cities.size()) {
                    return true;
                }
            }
        }
        return false;
    }


}
