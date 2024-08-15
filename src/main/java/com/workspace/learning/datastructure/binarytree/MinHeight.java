package com.workspace.learning.datastructure.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinHeight {
    /*
    https://leetcode.com/problems/minimum-height-trees/
     */

    public static void main(String[] args) {

        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(findMinHeightTreesADJ(n, edges));

    }


    public static List<Integer> findMinHeightTreesADJ(int n, int[][] edges) {

        int [] deg = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < edges.length; i++) {

            deg[edges[i][0]]++;
            deg[edges[i][1]]++;
            map.computeIfAbsent(edges[i][0], x->new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], x->new ArrayList<>()).add(edges[i][0]);

        }

        for (int i = 0; i < n; i++) {
            if(deg[i]==1){
                queue.offer(i);
            }
        }

        int remainingNodes = n;

        while (remainingNodes>2){

            int size = queue.size();
            remainingNodes = remainingNodes-size;

            for (int i = 0; i < size && !queue.isEmpty(); i++) {

                int leaf = queue.poll();
                for (Integer neighbour: map.get(leaf)) {
                    deg[neighbour]--;
                    if(deg[neighbour]==1){
                        queue.offer(neighbour);
                    }
                }

            }
        }

        return new ArrayList<>(queue);

    }



    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int[] arr = new int[n];

        int minHeight = Integer.MAX_VALUE;

        for (int i = 0; i < edges.length; i++) {

            List<Integer> list = adjMap.computeIfAbsent(edges[i][0], (k) -> new ArrayList<Integer>());
            list.add(edges[i][1]);
            List<Integer> list2 = adjMap.computeIfAbsent(edges[i][1], (k) -> new ArrayList<Integer>());
            list2.add(edges[i][0]);

        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            if (!visited[i]) {
                int level = 0;
                visited[i] = true;
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int size = queue.size();

                    for (int j = 0; j < size && !queue.isEmpty(); j++) {

                        int curr = queue.poll();
                        visited[curr] = true;

                        if (adjMap.containsKey(curr)) {

                            List<Integer> list = adjMap.get(curr);

                            for (Integer node : list) {
                                if (!visited[node]) {
                                    queue.offer(node);
                                }
                            }
                        }
                    }
                    level++;
                }
                arr[i] = level - 1;
                minHeight = Math.min(arr[i], minHeight);
            }
        }

        ArrayList<Integer> minHeightList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            if (minHeight == arr[i]) {
                minHeightList.add(i);
            }

        }

        return minHeightList;
    }


}
