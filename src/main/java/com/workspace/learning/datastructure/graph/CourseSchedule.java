package com.workspace.learning.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    //https://leetcode.com/problems/course-schedule/description/
    public static void main(String[] args) {

        int numCourses = 2;
        int[][] prerequisites = {{1, 1}};
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}, {0, 1}};
        int numCourses2 = 5;
        int[][] prerequisites2 = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        //[[1,4],[2,4],[3,1],[3,2]]
        System.out.println(canFinish(numCourses2, prerequisites2));
        // System.out.println(canFinish(numCourses1, prerequisites1));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites.length <= 0) {
            return true;
        }
        boolean canFinishCourses = true;
        boolean[] vis = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {

            graph.computeIfAbsent(prerequisites[i][1], (k) -> new ArrayList<>())
                    .add(prerequisites[i][0]);
        }

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()
        ) {
            if (!vis[entry.getKey()]) {
                canFinishCourses = dfs(graph, entry.getKey(), vis, rec);
                if (!canFinishCourses) {
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean dfs(Map<Integer, List<Integer>> graph, int curr, boolean[] vis, boolean[] rec) {

        if (graph.containsKey(curr)) {
            List<Integer> nextCourseList = graph.get(curr);
            vis[curr] = true;
            rec[curr] = true;

            for (Integer neighbour : nextCourseList) {
                if (rec[neighbour]) {
                    return false; // condition for cycle detection
                } else if (!vis[neighbour]) {
                     if(!dfs(graph, neighbour, vis, rec)){  // if course can not be finished return false
                         return false;
                     }
                }
            }
        }
        rec[curr] = false;
        return true;
    }
}