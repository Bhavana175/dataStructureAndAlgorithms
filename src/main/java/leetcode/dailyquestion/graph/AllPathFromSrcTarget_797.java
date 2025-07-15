package leetcode.dailyquestion.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSrcTarget_797 {
    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> singlePath = new ArrayList<>();
        int n = graph.length;

        singlePath.add(0);
        dfs(graph, 0, n - 1, singlePath, result);

        return result;
    }

    private static void dfs(int[][] graph, int curr, int target, List<Integer> singlePath, List<List<Integer>> result) {

        if (curr == target) {
            result.add(new ArrayList<>(singlePath));
            return;
        }
        for (int i = 0; i < graph[curr].length; i++) {
            int next = graph[curr][i];
            singlePath.add(next);
            dfs(graph, next, target, singlePath, result);
            singlePath.remove(singlePath.size() - 1);
        }
    }
}
