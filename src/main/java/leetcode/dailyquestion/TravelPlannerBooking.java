package leetcode.dailyquestion;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.*;

/*
Given a Map of Cities to prices for the days(Map<String, List<Integer>>)
example:
Paris : 10,12,14,11,15,18,17,13,19
Zurich: 18,20,14,21,13,15,19,20,11
Amsterdam: 12, 19, 11, 15,12,14,16,17,19

Help a person in planning a trip covering all the cities, in each city the person would be staying for 'x' days. And the person has a max budget 'budget'.
Return a list of prices(combination of cities) a user can visit within budget..

Output example :
137, 148, .........

write the code in java


 */
public class TravelPlannerBooking {

    // Example usage
    public static void main(String[] args) {
        Map<String, List<Integer>> cityPrices = new LinkedHashMap<>();
        cityPrices.put("Paris", Arrays.asList(10,12,14,11,15,18,17,13,19));
        cityPrices.put("Zurich", Arrays.asList(18,20,14,21,13,15,19,20,11));
        cityPrices.put("Amsterdam", Arrays.asList(12,19,11,15,12,14,16,17,19));

        int x = 3; // Days per city
        int budget = 150;

        List<Integer> validCosts = findTripCosts(cityPrices, x, budget);
        System.out.println("Possible trip costs within budget: " + validCosts);
    }

    public static List<Integer> findTripCosts(Map<String, List<Integer>> cityPrices, int x, int budget) {
        List<List<Integer>> allCityCosts = new ArrayList<>();

        // Step 1: Generate all possible x-day stay costs for each city
        for (List<Integer> prices : cityPrices.values()) {
            List<Integer> cityOptions = new ArrayList<>();
            for (int i = 0; i <= prices.size() - x; i++) {
                int sum = 0;
                for (int j = 0; j < x; j++) {
                    sum += prices.get(i + j);
                }
                cityOptions.add(sum);
            }
            allCityCosts.add(cityOptions);
        }

        // Step 2: Backtrack through all combinations (only one stay per city)
        List<Integer> result = new ArrayList<>();
        backtrack(allCityCosts, 0, 0, budget, result);
        return result;
    }

    private static void backtrack(List<List<Integer>> allCityCosts, int cityIndex, int currentSum, int budget, List<Integer> result) {
        if (cityIndex == allCityCosts.size()) {
            if (currentSum <= budget) {
                result.add(currentSum);
            }
            return;
        }

        for (int cost : allCityCosts.get(cityIndex)) {
            if (currentSum + cost <= budget) {
                backtrack(allCityCosts, cityIndex + 1, currentSum + cost, budget, result);
            }
        }
    }


}
