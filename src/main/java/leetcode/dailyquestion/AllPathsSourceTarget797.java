package leetcode.dailyquestion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget797 {

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        AllPathsSourceTarget797 obj = new AllPathsSourceTarget797();
        System.out.println(obj.allPathsSourceTarget(graph));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> output = new ArrayList<>();
        int n = graph.length;
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfs(graph, 0, n - 1, path, output);

        return output;
    }

    private void dfs(int[][] graph, int curr, int des, List<Integer> path, List<List<Integer>> result) {

        if (curr == des) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[curr].length; i++) {
            int neighbour = graph[curr][i];
            path.add(neighbour);
            dfs(graph, neighbour, des, path, result);
            path.remove(path.size() - 1);
        }

    }

}
