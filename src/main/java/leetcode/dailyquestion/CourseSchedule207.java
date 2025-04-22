package leetcode.dailyquestion;

import java.util.ArrayList;

public class CourseSchedule207 {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //directed graph, if cycle present can finish

        //create graph

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        boolean[] vis = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (!dfs(graph, vis, i, rec)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(ArrayList<Integer>[] graph, boolean[] vis, int curr, boolean[] rec) {

        vis[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            int nextCourse = graph[curr].get(i);
            if (rec[nextCourse]) {
                return false;
            } else if (!vis[nextCourse] && !dfs(graph, vis, nextCourse, rec)) {
                return false;
            }

        }
        rec[curr] = false;
        return true;
    }

}
