package leetcode.dailyquestion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ValidPathGraph1971 {

    public static void main(String[] args) {

        int n = 6;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0, destination = 5;

        System.out.println(validPath(n, edges, source, destination));

    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        List<Integer>[] graph = new List[n];
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        queue.offer(source);
        vis[source] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == destination) {
                return true;
            }
            List<Integer> neighbours = graph[curr];
            for (Integer node : neighbours) {
                if (!vis[node]) {
                    queue.offer(node);
                    vis[node] = true;
                }
            }
        }
        return false;
    }
}
