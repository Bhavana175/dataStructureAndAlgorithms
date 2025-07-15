package leetcode.dailyquestion.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule_207 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(canFinish(numCourses, prerequisites));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new List[numCourses];
        boolean[] vis = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (isCycle(graph, vis, rec, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isCycle(List<Integer>[] graph, boolean[] vis, boolean[] rec, int currCourse) {

        vis[currCourse] = true;
        rec[currCourse] = true;

        for (int i = 0; i < graph[currCourse].size(); i++) {
            int preReqCourse = graph[currCourse].get(i);
            if (rec[preReqCourse]) {
                return true; // cycle condition
            } else if (!vis[preReqCourse] && isCycle(graph, vis, rec, preReqCourse)) {
                return true;
            }
        }
        rec[currCourse] = false;
        return false;
    }
}
