package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.List;

public class FindCheapestPrice787 {

    public static void main(String[] args) {

        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;

        FindCheapestPrice787 obj = new FindCheapestPrice787();
        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));

    }

    private class Path {
        int des;
        int price;

        public Path(int des, int price) {
            this.des = des;
            this.price = price;
        }

        public int getDes() {
            return des;
        }

        public void setDes(int des) {
            this.des = des;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        //n cities , k stops, cheapest flight
        //is it directed acyclic or cyclic ?
        int minPrice = Integer.MAX_VALUE;
        List<Path>[] graph = new List[n];

        //create graph
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Path(flights[i][1], flights[i][2]));
        }

        minPrice = dfs(graph, src, dst, k+1, 0, 0, minPrice);

        if (minPrice != Integer.MAX_VALUE) return minPrice;
        return -1;

    }

    private int dfs(List<Path>[] graph, int curr, int dst, int k, int stops, int cost, int minPrice) {

        if (curr == dst) {
            return Math.min(cost, minPrice);
        }

        if (stops == k) {
            return minPrice;
        }

        for (int i = 0; i < graph[curr].size(); i++) {

            Path nei = graph[curr].get(i);

            if (cost + nei.price >= minPrice) continue; // pruning
            minPrice = dfs(graph, nei.des, dst, k, stops + 1,  cost + nei.price, minPrice);

        }

        return minPrice;
    }

}
