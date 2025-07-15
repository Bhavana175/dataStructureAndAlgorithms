package leetcode.dailyquestion.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CourseSchedule_II_210 {
    public static void main(String[] args) {
        int  numCourses = 4;
        int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        //Output: [0,2,1,3]
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new List[numCourses];
        boolean [] vis = new boolean[numCourses];
        boolean [] rec = new boolean[numCourses];
        Stack<Integer> courseOrderStack = new Stack<>();
        int [] output = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(!vis[i]){
               if(isCycle(graph, vis, rec, courseOrderStack, i)){
                   return new int[]{};
               }
            }
        }
        int index =numCourses-1;
        while (!courseOrderStack.isEmpty()){
            output[index]= courseOrderStack.pop();
            index--;
        }
        return output;
    }

    private static boolean isCycle(List<Integer>[] graph, boolean[] vis, boolean[] rec, Stack<Integer> courseOrderStack, int currCourse) {
        vis[currCourse] = true;
        rec[currCourse] = true;

        for (int i = 0; i < graph[currCourse].size(); i++) {
            int preReqCourse = graph[currCourse].get(i);
            if(rec[preReqCourse]){
                return true; //cycle condition
            }else if(!vis[preReqCourse] && isCycle(graph, vis, rec,courseOrderStack, preReqCourse)){
                return true;
            }

        }
        rec[currCourse] = false;
        courseOrderStack.push(currCourse);
        return false;
    }
}
