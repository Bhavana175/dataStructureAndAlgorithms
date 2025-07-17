package leetcode.dailyquestion.booking_practice;

import java.util.*;

public class PathAllCities {
    public static void main(String[] args) {
        List<String[]> flights1 = Arrays.asList(
                new String[]{"A", "B"},
                new String[]{"B", "C"},
                new String[]{"C", "D"},
                new String[]{"E", "F"}
        );

        pathCoveringAllCities(flights1);
        System.out.println();
        pathCoveringAllCitiesWithBfsTopo(flights1);
    }

    public static void pathCoveringAllCitiesWithBfsTopo(List<String[]> flights) {

        HashMap<String, List<String>> graph = new HashMap<>();
        HashSet<String> cities = new HashSet<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        List<String> path = new ArrayList<>();

        for (int i = 0; i < flights.size(); i++) {
            graph.computeIfAbsent(flights.get(i)[0], (k) -> new ArrayList<>()).add(flights.get(i)[1]);
            cities.add(flights.get(i)[0]);
            cities.add(flights.get(i)[1]);
            indegree.put(flights.get(i)[1], indegree.getOrDefault(flights.get(i)[1], 0) + 1);
        }

        for (String city : cities) {
            if (!indegree.containsKey(city)) {
                queue.offer(city);
            }
        }

        while (!queue.isEmpty()) {
            String currCity = queue.poll();
            path.add(currCity);
            if (graph.containsKey(currCity)) {
                for (String nextCity : graph.get(currCity)) {
                    indegree.put(nextCity, indegree.getOrDefault(nextCity,0) - 1);
                    if (indegree.get(nextCity) == 0) {
                        queue.offer(nextCity);
                    }
                }
            }
        }

        if (path.size() == cities.size()) {
            path.forEach((s) -> System.out.print(s + " "));
        } else System.out.println("not possible ");

    }

    public static void pathCoveringAllCities(List<String[]> flights) {

        HashMap<String, List<String>> graph = new HashMap<>();
        HashSet<String> cities = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> rec = new HashSet<>();
        Stack<String> stack = new Stack<>();


        for (int i = 0; i < flights.size(); i++) {
            graph.computeIfAbsent(flights.get(i)[0], (k) -> new ArrayList<>()).add(flights.get(i)[1]);
            cities.add(flights.get(i)[0]);
            cities.add(flights.get(i)[1]);
        }

        for (String city : cities) {
            if (!visited.contains(city)) {
                if (topoWithCycleDetection(graph, visited, rec, stack, city)) {
                    System.out.println(" not possible cycle detected");
                    return;
                }
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static boolean topoWithCycleDetection(HashMap<String, List<String>> graph, HashSet<String> visited, HashSet<String> rec, Stack<String> stack, String currCity) {

        visited.add(currCity);
        rec.add(currCity);

        if (graph.containsKey(currCity)) {
            for (String nextCity : graph.get(currCity)) {
                if (rec.contains(nextCity)) return true; // cycle condition
                if (!visited.contains(nextCity) && topoWithCycleDetection(graph, visited, rec, stack, nextCity)) {
                    return true;
                }
            }
        }
        rec.remove(currCity);
        stack.push(currCity);
        return false;
    }

}
