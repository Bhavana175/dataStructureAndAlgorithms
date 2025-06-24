package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseSchedule207_1 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(new CourseSchedule207_1().canFinish(numCourses, prerequisites));
    }

    //cycle detection in directed graph
    // dfs , rec stack
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] rec = new boolean[numCourses];
        boolean[] vis = new boolean[numCourses];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        //  List<Integer> [] graph = new List[numCourses];

        for (int[] prerequisite : prerequisites) {
            graph.computeIfAbsent(prerequisite[0], (k) -> new ArrayList<>()).add(prerequisite[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                boolean isCycle = dfs(graph, vis, rec, i);
                if (isCycle) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(HashMap<Integer, List<Integer>> graph, boolean[] vis, boolean[] rec, int curr) {

        vis[curr] = true;
        rec[curr] = true;

        if (graph.containsKey(curr)) {
            for (int i = 0; i < graph.get(curr).size(); i++) {
                int nextNode = graph.get(curr).get(i);
                if (rec[nextNode]) {
                    return true;
                } else if (!vis[nextNode] && dfs(graph, vis, rec, nextNode)) {
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }
}
