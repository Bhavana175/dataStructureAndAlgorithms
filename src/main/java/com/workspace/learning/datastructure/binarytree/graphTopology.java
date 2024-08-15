package com.workspace.learning.datastructure.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class graphTopology {

    public static void main(String[] args) {

        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(findMinHeightTrees(n, edges));

    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();

        if (n <= 0) {
            return ans;
        }

        if (n == 1) {
            ans.add(0);
            return ans;
        }

        int[] deg = new int[n];
        List<List<Integer>> gr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            deg[e[0]]++;
            deg[e[1]]++;

            gr.get(e[0]).add(e[1]);
            gr.get(e[1]).add(e[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) {
                q.offer(i);
            }
        }

        while (n > 2) {
            int sz = q.size();
            n -= sz;

            while (sz-- > 0) {
                int el = q.poll();

                for (int ne : gr.get(el)) {
                    deg[ne]--;
                    if (deg[ne] == 1) {
                        q.offer(ne);
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        return ans;
    }

}
