package leetcode.dailyquestion;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class FindCheapestPrice787_Dijktras {

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;

        FindCheapestPrice787_Dijktras obj = new FindCheapestPrice787_Dijktras();
        //  System.out.println(obj.findCheapestPrice(n,flights,src,dst,k));

        int[][] flights1 = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};

        System.out.println(obj.findCheapestPrice(n, flights1, src, dst, k));

    }


    public class Pair  {
        int node;
        int price;
        int stops;

        public Pair(int node, int price, int stops) {
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

        public int getStops() {
            return stops;
        }

        public void setStops(int stops) {
            this.stops = stops;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }


    }


    public class Edges {
        int des;
        int price;

        public Edges(int des, int price) {
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

        int[] dist = new int[n];
        Queue<Pair> pq = new ArrayDeque<>();

        //create graph
        ArrayList<Edges>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src]=0;

        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edges( flights[i][1], flights[i][2]));
        }

        //bfs
        pq.add(new Pair(src, 0, -1));

        while (!pq.isEmpty()) {

            Pair curr = pq.remove();
            int currPrice = curr.price;

            for (int i = 0; i < graph[curr.node].size(); i++) {

                Edges e = graph[curr.node].get(i);
                int v = e.des;
                int wt = e.price;
                if (curr.stops+1 <= k && currPrice + wt < dist[v]) {
                    dist[v] = currPrice + wt;
                    pq.add(new Pair(v, dist[v], curr.stops + 1));
                }

            }

        }

        return dist[dst];
    }


}
