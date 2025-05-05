package leetcode.dailyquestion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.*;

// Todo(visit)- https://leetcode.com/discuss/post/4046098/booking-holdings-sde-2-bangalore-selecte-339z/
// Todo(Visit)- https://leetcode.com/discuss/post/6616513/booking-holdings-sde-2-banglore-january-m03an/
// Todo(Visit)- https://www.hellointerview.com/learn/system-design/problem-breakdowns/ticketmaster
// Todo(Visit)- https://medium.com/booking-com-development/leverage-graph-technology-for-real-time-fraud-detection-and-prevention-438336076ea5


public class TripPlannerBookingSelf {

    public static void main(String[] args) {
        Map<String, List<Integer>> cityPrices = new HashMap<>();
        cityPrices.put("Paris", Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3));
        cityPrices.put("Zurich", Arrays.asList(3, 3, 3, 2, 2, 2, 1, 1, 1));
        cityPrices.put("Amsterdam", Arrays.asList(2, 2, 2, 3, 3, 3, 1, 1, 1));

        int x = 3;  // Number of days to stay in each city
        int budget = 25;  // Maximum budget

        // Get all valid plans
        System.out.println(findTripInBudget(cityPrices, x, budget));


        Map<String, List<Integer>> cityPrices1 = new HashMap<>();
        cityPrices1.put("Paris",    Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5));
        cityPrices1.put("Zurich",   Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5));
        cityPrices1.put("Amsterdam",Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5));
        int x1 = 3;
        int budget1 = 10;

        System.out.println(findTripInBudget(cityPrices1, x1, budget1));

        Map<String, List<Integer>> cityPrices2 = new HashMap<>();
        cityPrices2.put("Paris",    Arrays.asList(1, 1, 1, 9, 9, 9, 9, 9, 9));
        cityPrices2.put("Zurich",   Arrays.asList(9, 9, 9, 9, 9, 9, 1, 1, 1));
        cityPrices2.put("Amsterdam",Arrays.asList(9, 9, 9, 1, 1, 1, 9, 9, 9));
        int x2 = 3;
        int budget2 = 10;

        System.out.println(findTripInBudget(cityPrices2, x2, budget2));

        Map<String, List<Integer>> cityPrices3 = new HashMap<>();
        cityPrices3.put("Paris",    Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1));
        cityPrices3.put("Zurich",   Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1));
        cityPrices3.put("Amsterdam",Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1));
        int x3 = 3;
        int budget3 = 9;
        System.out.println(findTripInBudget(cityPrices3, x3, budget3));


    }

    @Data
    @AllArgsConstructor
    @ToString
    private static class CityPlan {
        String cityName;
        List<Integer> indexes;
        int perCityCost;

    }

    public static List<Integer> findTripInBudget(Map<String, List<Integer>> cityPricesMap, int days, int maxBudget) {

        HashSet<String> totalCities = new HashSet<>(cityPricesMap.keySet());
        List<Integer> result = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        List<CityPlan> cityPlanList = new ArrayList<>();
        int cityCount = totalCities.size();
        List<List<CityPlan>> combinations = new ArrayList<>();

        //assuming cityPrices.getKey().size() = days * totalCities.size();
        // ex 3 consecutive days in each city, 3 cities => 9 days price list given

        //calculate budget starting from any city
       // int TotalDays = cityPricesMap.get(totalCities.stream().findFirst()).size();
      /*
        int i1= 0; //(0,1,2,3,---day-1)
        int i2 = days; // (day, day+1, --- 2*day-1)
        int i3 = 2 * days;
        */
        for (String currCity: totalCities) {
            recursion(cityPricesMap, days, maxBudget, visited, cityCount, cityPlanList, result, totalCities, currCity, 0 , combinations);
        }
/*        for (List<CityPlan> plan : combinations){
            System.out.println("======================");
            for (CityPlan p: plan){
                System.out.println(p);
            }
            System.out.println("======================");
        }*/
        Collections.sort(result);
        return result;

    }

    private static void recursion(Map<String, List<Integer>> cityPricesMap,
                                  int days, int maxBudget,
                                  HashSet<String> visited,
                                  int cityCount, List<CityPlan> cityPlanList,
                                  List<Integer> result, HashSet<String> totalCities, String currCity, int sum , List<List<CityPlan>> combinations) {

        if (visited.size() == cityCount) {

            if (sum <= maxBudget ) {
                result.add(sum);
                for(CityPlan cp : cityPlanList){
                    System.out.println(cp);
                }
            }
            if(cityPricesMap.size()== totalCities.size()){
                combinations.add(cityPlanList);
                cityPlanList = new ArrayList<>();
            }

        }
            int sumCity = 0;
            if (visited.contains(currCity)) return;

            List<Integer> prices = cityPricesMap.get(currCity);
            List<Integer> indexList = new ArrayList<>();
            // city prices for x days added
            for (int i = visited.size() * days; i < (visited.size() + 1) * days; i++) {
                sumCity += prices.get(i);
                indexList.add(i);
            }
            CityPlan cityPlan = new CityPlan(currCity, indexList, sumCity);
            cityPlanList.add(cityPlan);
            visited.add(currCity);

            for(String city: totalCities) {
                recursion(cityPricesMap, days, maxBudget, visited, cityCount, cityPlanList, result, totalCities, city, sum + sumCity, combinations);
            }

         visited.remove(currCity);
         cityPlanList.remove(cityPlanList.size()-1);
    }

}