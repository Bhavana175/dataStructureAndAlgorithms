package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountVisitedNodeDirectedGraph2876 {

    public static void main(String[] args) {

        List<Integer> edges = Arrays.asList(1, 2, 0, 0);
        System.out.println(Arrays.toString(countVisitedNodes(edges)));
    }

    public static int[] countVisitedNodes(List<Integer> edges) {

        int n = edges.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            boolean[] vis = new boolean[n];
            List<Integer> list = new ArrayList<>();
            dfs(edges, i, vis, list);
            ans[i] = list.size();
        }

        return ans;
    }

    private static void dfs(List<Integer> edges, int curr, boolean[] vis, List<Integer> list) {
        if (vis[curr]) {
            return;
        }
        vis[curr] = true;
        list.add(curr);
        dfs(edges, edges.get(curr), vis, list);

    }
}
