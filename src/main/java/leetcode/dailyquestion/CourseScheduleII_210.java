package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII_210 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        CourseScheduleII_210 obj = new CourseScheduleII_210();
        System.out.println(Arrays.toString(obj.findOrder(numCourses, prerequisites)));
    }


        /*
        Time: O(V + E) = number of courses + number of prerequisites.
        Space: O(V + E) for graph + visited arrays + recursion stack.
         */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //dfs, rec[] vis[] , stack , pop elements
        boolean[] vis = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];
        List<Integer>[] graph = new List[numCourses];
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                boolean isCycle = dfs(graph, vis, rec, stack, i);
                if (isCycle) {
                    return new int[]{};
                }
            }
        }

        int[] output = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            output[i++] = stack.pop();
        }
        return output;
    }

    private boolean dfs(List<Integer>[] graph, boolean[] vis, boolean[] rec, Stack<Integer> stack, int curr) {
        vis[curr] = true;
        rec[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            int nextCourse = graph[curr].get(i);
            if (rec[nextCourse]) return true; // cycle condition
            if (!vis[nextCourse] && dfs(graph, vis, rec, stack, nextCourse)) {
                return true;
            }
        }
        stack.push(curr);
        rec[curr] = false;
        return false;
    }
}
