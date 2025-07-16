package leetcode.dailyquestion.graph;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindCheapestPrice_787_Dijktras {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;

        System.out.println(findCheapestPrice(n,flights,src,dst,k));

    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<Edge>[] graph = new List[n];
        int[] stopVsPrice = new int[n];
        Queue<FlightInfo> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            stopVsPrice[i] = Integer.MAX_VALUE;
        }
        stopVsPrice[src] = 0;

        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][1], flights[i][2]));
        }
        queue.offer(new FlightInfo(src, 0, -1));

        while (!queue.isEmpty()) {

            FlightInfo currNode = queue.poll();
            int currPrice = currNode.price;
            int currStop = currNode.stops;

            for (int i = 0; i < graph[currNode.node].size(); i++) {

                Edge nextStop = graph[currNode.node].get(i);
                int nxtStopPrice = nextStop.price;
                int nxtStopVal = nextStop.getV();

                if (currStop + 1 <= k && nxtStopPrice + currPrice <= stopVsPrice[nxtStopVal]) {
                    stopVsPrice[nxtStopVal] = nxtStopPrice + currPrice;
                    queue.offer(new FlightInfo(nxtStopVal, nxtStopPrice + currPrice, currStop+1));
                }
            }
        }
        return stopVsPrice[dst]==Integer.MAX_VALUE?-1:stopVsPrice[dst];
    }


    static class Edge {
        int v;
        int price;

        public Edge(int v, int price) {
            this.v = v;
            this.price = price;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }


    static class FlightInfo {
        int node;
        int price;
        int stops;

        public FlightInfo(int node, int price, int stops) {
            this.node = node;
            this.price = price;
            this.stops = stops;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getStops() {
            return stops;
        }

        public void setStops(int stops) {
            this.stops = stops;
        }
    }

}
