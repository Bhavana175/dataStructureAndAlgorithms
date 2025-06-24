package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSrcToTar797 {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int src = 0;
        int n = graph.length;
        int tar = n - 1;
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        path.add(src);

        dfs(graph, path, src, tar, output);
        return output;
    }

    private static void dfs(int[][] graph, List<Integer> path, int curr,
                            int tar, List<List<Integer>> output) {

        if (curr == tar) {
            output.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[curr].length; i++) {
            int nextNode = graph[curr][i];
            path.add(nextNode);
            dfs(graph, path, nextNode, tar, output);
            path.remove(path.size()-1);
        }


    }
}
