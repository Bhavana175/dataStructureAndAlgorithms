package leetcode.dailyquestion.practice;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int [][] prerequisites = {{1,0},{0,1}};

        System.out.println(new CourseSchedule().canFinish(numCourses,prerequisites));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean isCycle = false;

        //create graph
        List<Integer> [] graph = new List[numCourses];
        boolean [] vis = new boolean[numCourses];
        boolean [] rec = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(!vis[i]){
            if(dfs(graph, vis, rec, i)){
                return false;
            }
            }
        }

        return !isCycle;
    }

    private boolean dfs(List<Integer>[] graph, boolean[] vis, boolean[] rec, int i) {

        vis[i]= true;
        rec[i] = true;

        for (Integer next: graph[i]){

            if(rec[next]){
                return true;
            }else if(!vis[next] && dfs(graph,vis,rec, next)){
                return true;
            }

        }
        rec[i]=false;
        return false;
    }
}
