package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TravelPlannerXDaysBackTracking {

    public static void main(String[] args) {
        Map<String, List<Integer>> cp = Map.of(
                "Paris", List.of(1, 1, 1, 2, 2, 2, 3, 3, 3),
                "Zurich", List.of(3, 3, 3, 2, 2, 2, 1, 1, 1),
                "Amsterdam", List.of(2, 2, 2, 3, 3, 3, 1, 1, 1)
        );
        System.out.println(new TravelPlannerXDaysBackTracking().findWays(cp, 3, 25));
    }

    public List<Integer> findWays(Map<String, List<Integer>> prices, int x, int budget) {
        List<String> cities = new ArrayList<>(prices.keySet());
        List<Integer> res = new ArrayList<>();

        backtrack(prices, cities, x, budget, 0, 0, new boolean[cities.size()], res);

        Collections.sort(res);
        return res;
    }

    private void backtrack(Map<String, List<Integer>> prices,
                           List<String> cities,
                           int x, int budget,
                           int offset, int cost,
                           boolean[] vis,
                           List<Integer> res) {

        if (offset == cities.size() * x) {
            res.add(cost);
            return;
        }

        for (int i = 0; i < cities.size(); i++)
            if (!vis[i]) {

                int c = cost;
                List<Integer> p = prices.get(cities.get(i));

                for (int d = 0; d < x; d++)
                    c += p.get(offset + d);

                if (c <= budget) {
                    vis[i] = true;
                    backtrack(prices, cities, x, budget, offset + x, c, vis, res);
                    vis[i] = false;
                }
            }
    }
}
