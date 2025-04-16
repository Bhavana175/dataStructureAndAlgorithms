package leetcode.dailyquestion;

import java.util.HashMap;
import java.util.*;


//https://leetcode.com/discuss/post/6616513/booking-holdings-sde-2-banglore-january-m03an/
public class CityStayTravelPlanner {
    static class Plan {
        List<String> citySequence;
        Map<String, List<Integer>> stayDays;
        int totalCost;

        Plan(List<String> citySequence, Map<String, List<Integer>> stayDays, int totalCost) {
            this.citySequence = citySequence;
            this.stayDays = stayDays;
            this.totalCost = totalCost;
        }
    }

    // Main method to generate valid travel plans
    public static List<Plan> findValidPlans(Map<String, List<Integer>> cityPrices, int x, int budget) {
        List<Plan> results = new ArrayList<>();
        List<String> cities = new ArrayList<>(cityPrices.keySet());  // List of cities

        // Generate all city permutations manually
        List<List<String>> cityPermutations = getCityPermutations(cities);

        // Try different combinations of 3-day blocks for each permutation
        for (List<String> cityOrder : cityPermutations) {
            for (int i = 0; i <= 9 - 3 * x; i++) {  // Start day for city 1
                for (int j = i + 3; j <= 9 - 2 * x; j++) {  // Start day for city 2
                    for (int k = j + 3; k <= 9 - x; k++) {  // Start day for city 3
                        Map<String, Integer> cityToStart = new HashMap<>();
                        cityToStart.put(cityOrder.get(0), i);
                        cityToStart.put(cityOrder.get(1), j);
                        cityToStart.put(cityOrder.get(2), k);

                        Set<Integer> usedDays = new HashSet<>();
                        Map<String, List<Integer>> cityDayMap = new HashMap<>();
                        int totalCost = 0;
                        boolean valid = true;

                        // Iterate through cities and calculate the cost
                        for (String city : cityOrder) {
                            int start = cityToStart.get(city);
                            List<Integer> prices = cityPrices.get(city);
                            List<Integer> days = new ArrayList<>();

                            // Select the days to stay in the city
                            for (int d = start; d < start + x; d++) {
                                if (usedDays.contains(d)) {
                                    valid = false;  // Check for overlapping days
                                    break;
                                }
                                days.add(d);
                                usedDays.add(d);
                                totalCost += prices.get(d);  // Add cost for that day
                            }

                            if (!valid) break;
                            cityDayMap.put(city, days);
                        }

                        // If valid and total cost is within budget, store the plan
                        if (valid && totalCost <= budget) {
                            results.add(new Plan(cityOrder, cityDayMap, totalCost));
                        }
                    }
                }
            }
        }

        return results;
    }

    // Helper function to generate all city permutations
    private static List<List<String>> getCityPermutations(List<String> cities) {
        List<List<String>> result = new ArrayList<>();
        if (cities.size() == 1) {
            result.add(new ArrayList<>(cities));
            return result;
        }

        // Generate permutations by fixing each city at the start
        for (int i = 0; i < cities.size(); i++) {
            String currentCity = cities.get(i);
            List<String> remainingCities = new ArrayList<>(cities);
            remainingCities.remove(i);

            // Generate permutations for the remaining cities
            for (List<String> perm : getCityPermutations(remainingCities)) {
                perm.add(0, currentCity);
                result.add(perm);
            }
        }
        return result;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Map<String, List<Integer>> cityPrices = new HashMap<>();
        cityPrices.put("Paris", Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3));
        cityPrices.put("Zurich", Arrays.asList(3, 3, 3, 2, 2, 2, 1, 1, 1));
        cityPrices.put("Amsterdam", Arrays.asList(2, 2, 2, 3, 3, 3, 1, 1, 1));

        int x = 3;  // Number of days to stay in each city
        int budget = 13;  // Maximum budget

        // Get all valid plans
        List<Plan> plans = findValidPlans(cityPrices, x, budget);

        // Print valid plans
        for (Plan plan : plans) {
            System.out.println("Total Cost: " + plan.totalCost + ", Sequence: " + plan.citySequence);
            System.out.println("Stay Days: " + plan.stayDays);
        }
    }
}
