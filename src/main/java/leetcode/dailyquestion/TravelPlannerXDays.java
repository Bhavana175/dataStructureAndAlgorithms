package leetcode.dailyquestion;

import java.util.*;

public class TravelPlannerXDays {

    public static void main(String[] args) {

        Map<String, List<Integer>> cityPrices = new HashMap<>();

        cityPrices.put("Paris", Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3));
        cityPrices.put("Zurich", Arrays.asList(3, 3, 3, 2, 2, 2, 1, 1, 1));
        cityPrices.put("Amsterdam", Arrays.asList(2, 2, 2, 3, 3, 3, 1, 1, 1));
        int x = 3;  // Number of days to stay in each city
        int budget = 25;  // Maximum budget
        TravelPlannerXDays obj = new TravelPlannerXDays();
        System.out.println(obj.findNumberOfWays(cityPrices, x, budget));

        // Get all valid plans
        System.out.println(obj.findNumberOfWays(cityPrices, x, budget));


        Map<String, List<Integer>> cityPrices1 = new HashMap<>();
        cityPrices1.put("Paris",    Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5));
        cityPrices1.put("Zurich",   Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5));
        cityPrices1.put("Amsterdam",Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5));
        int x1 = 3;
        int budget1 = 10;

        System.out.println(obj.findNumberOfWays(cityPrices1, x1, budget1));

        Map<String, List<Integer>> cityPrices2 = new HashMap<>();
        cityPrices2.put("Paris",    Arrays.asList(1, 1, 1, 9, 9, 9, 9, 9, 9));
        cityPrices2.put("Zurich",   Arrays.asList(9, 9, 9, 9, 9, 9, 1, 1, 1));
        cityPrices2.put("Amsterdam",Arrays.asList(9, 9, 9, 1, 1, 1, 9, 9, 9));
        int x2 = 3;
        int budget2 = 10;

        System.out.println(obj.findNumberOfWays(cityPrices2, x2, budget2));

        Map<String, List<Integer>> cityPrices3 = new HashMap<>();
        cityPrices3.put("Paris",    Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1));
        cityPrices3.put("Zurich",   Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1));
        cityPrices3.put("Amsterdam",Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1));
        int x3 = 3;
        int budget3 = 9;
        System.out.println(obj.findNumberOfWays(cityPrices3, x3, budget3));


    }

    public List<Integer> findNumberOfWays(Map<String, List<Integer>> cityPrices, int xDays, int budget) {

        ArrayList<String> totalCities = new ArrayList<>(cityPrices.keySet());
        HashSet<String> visitedCitySet = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        int cost = 0;

        for (String city : totalCities) {
            rec(cityPrices, totalCities, visitedCitySet, city, xDays, cost, budget, output);
        }
        Collections.sort(output);
        return output;
    }

    private void rec(Map<String, List<Integer>> cityPrices, ArrayList<String> totalCities,
                     HashSet<String> visited, String currCity,
                     int xDays, int costSoFar, int budget, List<Integer> output) {

        // If we've already visited this city, nothing to do
        if (visited.contains(currCity)) return;

        // Compute the cost for staying xDays in currCity at the correct offset
        int offset = visited.size() * xDays;
        int cityCost = 0;
        List<Integer> prices = cityPrices.get(currCity);
        for (int j = offset; j < offset + xDays; j++) {
            cityCost += prices.get(j);
        }

        int newCost = costSoFar + cityCost;
        // If over budget, prune
        if (newCost > budget) return;

        // Mark visited
        visited.add(currCity);

        // If we've now visited all cities, record and return immediately
        if (visited.size() == totalCities.size()) {
            output.add(newCost);
            visited.remove(currCity);
            return;
        }

        // Recurse on all unvisited cities
        for (String nextCity : totalCities) {
            rec(cityPrices, totalCities, visited, nextCity, xDays, newCost, budget, output);
        }

        // Backtrack
        visited.remove(currCity);
    }


}
