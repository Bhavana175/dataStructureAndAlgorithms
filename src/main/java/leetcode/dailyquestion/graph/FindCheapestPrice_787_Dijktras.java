package leetcode.dailyquestion.graph;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindCheapestPrice_787_Dijktras {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;

    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<Edge> [] graph = new List[n];
        int[] nodeVsPrice = new int[n];
        Queue<FlightInfo> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            nodeVsPrice[i] = Integer.MAX_VALUE;
        }
        nodeVsPrice[src] =0;

        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][1], flights[i][2]));
        }
        queue.offer(new FlightInfo(src, 0, -1));

        while (! queue.isEmpty()){

            FlightInfo currNode = queue.poll();
            int currPrice = currNode.price;
            int currStop = currNode.stops;
            for (int i = 0; i < graph[currNode.node].size(); i++) {

                Edge nextStop = graph[currNode.node].get(i);
                int wt = nextStop.price;
                int v = nextStop.getV();
               // if(currStop+1<=k && )

            }

        }

        return 0;
    }
    
    @Data
    @AllArgsConstructor
    static class Edge{
        int v;
        int price;
    }
    
    @Data
    @AllArgsConstructor
    static class FlightInfo{
        int node;
        int price;
        int stops;
    }
    
}
