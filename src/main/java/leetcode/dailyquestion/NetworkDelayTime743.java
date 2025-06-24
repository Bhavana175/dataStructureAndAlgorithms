package leetcode.dailyquestion;

import java.util.*;

public class NetworkDelayTime743 {
    public static void main(String[] args) {

        int[][] times = {{1, 2, 1}};
        int n = 2, k = 2;
        // Output: 2
        System.out.println(new NetworkDelayTime743().networkDelayTime(times, n, k));

    }

    public int networkDelayTime(int[][] times, int n, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        int[] distance = new int[n];
        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        HashSet<Integer> vis = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            distance[i - 1] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < times.length; i++) {
            graph.computeIfAbsent(times[i][0],
                    (l) -> new ArrayList<>()).add(new Edge(times[i][0], times[i][1], times[i][2]));

        }

        pq.offer(new Pair(k, 0));
        distance[k - 1] = 0;

        while (!pq.isEmpty() && vis.size() != n) {
            Pair currNode = pq.poll();
            if (currNode != null && !vis.contains(currNode.node)) {
                vis.add(currNode.node);
                if (graph.containsKey(currNode.node)) {
                    for (int i = 0; i < graph.get(currNode.node).size(); i++) {
                        int dest = graph.get(currNode.node).get(i).dest;
                        int wt = graph.get(currNode.node).get(i).wt;
                        if (currNode.dist + wt < distance[dest - 1]) {
                            distance[dest - 1] = currNode.dist + wt;
                            pq.add(new Pair(dest, distance[dest - 1]));
                        }
                    }
                }
            }
        }
        int max = 0;
        for (int d : distance) {
            if (d == Integer.MAX_VALUE) return -1;
            max = Math.max(max, d);
        }
        return max;
    }

    class Pair {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.wt = wt;
            this.dest = dest;
        }
    }
}
