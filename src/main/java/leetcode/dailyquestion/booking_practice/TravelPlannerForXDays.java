package leetcode.dailyquestion.booking_practice;

import leetcode.dailyquestion.TravelPlannerXDays;

import java.util.*;

public class TravelPlannerForXDays {
    public static void main(String[] args) {
        Map<String, List<Integer>> cityPrices = new HashMap<>();

        cityPrices.put("Paris", Arrays.asList(1, 1, 1, 2, 2, 2, 1, 1, 1));
        cityPrices.put("Zurich", Arrays.asList(3, 3, 3, 1, 1, 1, 3, 3, 3));
        cityPrices.put("Amsterdam", Arrays.asList(1, 1, 1, 3, 3, 3, 1, 1, 1));
        int days = 3;  // Number of days to stay in each city
        int budget = 9;  // Maximum budget

        // Get all valid plans
        System.out.println(findAllValidPlan(cityPrices, days, budget));

    }

    private static List<List<String>> findAllValidPlan(Map<String, List<Integer>> cityPrices, int days, int budget) {

        // assumption dates list cities*days

        HashSet<String> cities = new HashSet<>(cityPrices.keySet());
        HashSet<String> visited = new HashSet<>();
        Set<List<String>> output = new HashSet<>();
        List<String> trip = new ArrayList<>();

        List<Integer> hotelCost = new ArrayList<>();

        for (String city : cities) {
            dfs(cityPrices, city, cities, visited, days, budget, trip, output, 0, hotelCost);
        }
        hotelCost.forEach(h -> System.out.print(h + "  "));
        System.out.println();
        return output.stream().toList();
    }

    private static void dfs(Map<String, List<Integer>> cityPrices, String currCity,
                            HashSet<String> cities, HashSet<String> visited, int days,
                            int budget, List<String> trip, Set<List<String>> output, int cost, List<Integer> hotelCost) {


        if (!visited.contains(currCity)) {

            int offsetStart = visited.size() * days;
            int end = (visited.size() * days) + days;
            List<Integer> priceList = cityPrices.get(currCity);
            int sumCost = 0;
            for (int i = offsetStart; i < end; i++) {
                sumCost += priceList.get(i);
            }

            if (sumCost + cost <= budget) {
                visited.add(currCity);
                trip.add(currCity);
                if (visited.size() == cities.size()) {
                    if (cost <= budget) {
                        output.add(new ArrayList<>(trip));
                        hotelCost.add(cost + sumCost);
                    }
                } else {
                    for (String nextCity : cities) {
                        dfs(cityPrices, nextCity, cities, visited, days, budget, trip, output, sumCost + cost, hotelCost);
                    }
                }
                visited.remove(currCity);
                trip.remove(currCity);
            }
        }
    }
}
