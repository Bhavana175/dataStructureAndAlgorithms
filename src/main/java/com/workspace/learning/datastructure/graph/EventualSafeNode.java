package com.workspace.learning.datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class EventualSafeNode {

    //https://leetcode.com/problems/find-eventual-safe-states/description/
    public static void main(String[] args) {

        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}; //[[1,2],[2,3],[5],[0],[5],[],[]]
        int[][] graph2 = {{}, {0, 2, 3, 4}, {3}, {4}, {}}; //[[1,2],[2,3],[5],[0],[5],[],[]]
        List<Integer> output2 = eventualSafeNodes1(graph2);
        System.out.println(output2);

    }

    public static List<Integer> eventualSafeNodes1(int[][] graph) {
        int n = graph.length;
        List<Integer> safeNodes = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int[] outDegree = new int[n];
        Map<Integer, List<Integer>> reverseMap = new HashMap<>();

        //identify terminal node add to set

        for (int i = 0; i < n; i++) {
            if (graph[i].length == 0) {
                queue.add(i);
            } else {
                int[] neighbours = graph[i];
                outDegree[i] = outDegree[i] + neighbours.length;
                for (int j = 0; j < neighbours.length; j++) {
                    reverseMap.computeIfAbsent(neighbours[j], (k) -> new ArrayList<>()).add(i);
                }
            }

        }

        while (!queue.isEmpty()) {

            int safeNode = queue.poll();
            safeNodes.add(safeNode);
            if (reverseMap.containsKey(safeNode)) {
                for (Integer node : reverseMap.get(safeNode)
                ) {
                    outDegree[node]--;
                    if (outDegree[node] == 0) {
                        queue.add(node);
                    }
                }
            }
        }
        //  List<Integer> list = new ArrayList<>(safeNodes.stream().toList());
        Collections.sort(safeNodes);
        return safeNodes;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] state = new int[n]; // 0 = unvisited, 1 = visiting, 2 = safe
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(graph, state, i)) {
                res.add(i);
            }
        }

        return res;
    }

    private static boolean dfs(int[][] graph, int[] state, int curr) {
        if (state[curr] != 0) {
            return state[curr] == 2; // if visiting (1), it's part of a cycle, so return false
        }

        state[curr] = 1; // mark as visiting
        for (int neighbor : graph[curr]) {
            if (!dfs(graph, state, neighbor)) {
                return false; // if any neighbor is not safe, this node is not safe
            }
        }
        state[curr] = 2; // mark as safe
        return true;
    }
}
