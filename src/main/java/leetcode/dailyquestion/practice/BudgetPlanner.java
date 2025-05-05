package leetcode.dailyquestion.practice;

import java.util.*;

public class BudgetPlanner {

    public static void main(String[] args) {
        Map<String, List<Integer>> cityPrices = new HashMap<>();
        cityPrices.put("Paris", Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3));
        cityPrices.put("Zurich", Arrays.asList(3, 3, 3, 2, 2, 2, 1, 1, 1));
        cityPrices.put("Amsterdam", Arrays.asList(2, 2, 2, 3, 3, 3, 1, 1, 1));

        int x = 3;  // Number of days to stay in each city
        int budget = 13;  // Maximum budget

        // Get all valid plans
        System.out.println(getListOfBudget(cityPrices, x, budget));

    }

    private static List<Integer> getListOfBudget(Map<String, List<Integer>> cityPrices, int xDays, int budget) {
        List<Integer> outputList = new ArrayList<>();
        List<String> cities = new ArrayList<>(cityPrices.keySet());
        HashSet<String> visited = new HashSet<>();
        for(String startCity: cities){
            rec(cityPrices, cities, startCity, visited, outputList, xDays, 0, budget);
        }
        return outputList;
    }

    private static void rec(Map<String, List<Integer>> cityPrices, List<String> cities, String currCity,
                            HashSet<String> visited, List<Integer> outputList, int xDays, int cost,  int budget) {

        // check city !vis , cal cost<budget (vis.size = cities.size) add to output list

        if(visited.contains(currCity)) return;
        int newCost =0;
        // 0-x days x-2x, offset = vis.size*xDays, limit +xdays
        int offset = visited.size()*xDays;
        for (int i = offset; i <(offset+xDays) ; i++) {
            newCost+=cityPrices.get(currCity).get(i);
        }
        visited.add(currCity);
        cost+=newCost;
        if(visited.size()== cities.size()){
            if(cost<budget){
                outputList.add(cost);
            }
        }
        for (String nextCity: cities){
            rec(cityPrices,cities,nextCity,visited,outputList,xDays,cost,budget);
        }
        visited.remove(currCity);
    }
}
