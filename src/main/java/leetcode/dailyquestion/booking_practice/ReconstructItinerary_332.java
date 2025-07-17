package leetcode.dailyquestion.booking_practice;

import java.util.*;

public class ReconstructItinerary_332 {
    public static void main(String[] args) {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO"));
        System.out.println(findItinerary(tickets));

    }

    public static List<String> findItinerary(List<List<String>> tickets) {

        HashMap<String, PriorityQueue<String>> adjList = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();

        for (int i = 0; i < tickets.size(); i++) {
            adjList.computeIfAbsent(tickets.get(i).get(0),
                    (k)->new PriorityQueue<>()).offer(tickets.get(i).get(1));
        }

        dfs("JFK", adjList, result);

        return result;
    }

    private static void dfs(String curr, HashMap<String, PriorityQueue<String>> adjList, LinkedList<String> result) {

        PriorityQueue<String> destination = adjList.get(curr);
        while (destination != null && !destination.isEmpty() ){
            String nextAirport = destination.poll();
            dfs(nextAirport, adjList, result);
        }

        result.addFirst(curr);
    }
}
