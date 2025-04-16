package leetcode.dailyquestion;

import java.util.*;

public class OneDayOneCityPlanner {

    public static List<List<String>> planTrip(Map<String, List<Integer>> cityPrices, int maxBudget) {
        int days = cityPrices.values().iterator().next().size();
        List<String> cities = new ArrayList<>(cityPrices.keySet());

        List<List<String>> result = new ArrayList<>();
        backtrack(days, 0, new HashSet<>(), new ArrayList<>(), 0, maxBudget, cityPrices, cities, result);
        return result;
    }

    private static void backtrack(int totalDays, int day, Set<String> usedCities, List<String> currentTrip,
                                  int currentCost, int maxBudget, Map<String, List<Integer>> cityPrices,
                                  List<String> allCities, List<List<String>> result) {

        if (day == totalDays) {
            if (currentCost <= maxBudget) {
                result.add(new ArrayList<>(currentTrip));
            }
            return;
        }

        for (String city : allCities) {
            if (usedCities.contains(city)) continue;

            int priceForDay = cityPrices.get(city).get(day);
            if (currentCost + priceForDay > maxBudget) continue;

            usedCities.add(city);
            currentTrip.add(city);

            backtrack(totalDays, day + 1, usedCities, currentTrip, currentCost + priceForDay, maxBudget, cityPrices, allCities, result);

            usedCities.remove(city);
            currentTrip.remove(currentTrip.size() - 1);
        }
    }

    public static void main(String[] args) {
        Map<String, List<Integer>> cityPrices = new LinkedHashMap<>();
        cityPrices.put("Delhi", Arrays.asList(100, 200, 300));
        cityPrices.put("Mumbai", Arrays.asList(150, 180, 250));
        cityPrices.put("Goa", Arrays.asList(120, 170, 220));

        int maxBudget = 600;

        List<List<String>> trips = planTrip(cityPrices, maxBudget);

        for (List<String> trip : trips) {
            int total = 0;
            for (int day = 0; day < trip.size(); day++) {
                String city = trip.get(day);
                int cost = cityPrices.get(city).get(day);
                total += cost;
                System.out.print("Day " + (day + 1) + ": " + city + " (₹" + cost + "), ");
            }
            System.out.println("Total = ₹" + total);
        }
    }
}
