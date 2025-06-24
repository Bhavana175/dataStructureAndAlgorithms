package leetcode.dailyquestion;

import java.util.*;

public class EmployeeHierarchy {

    public static void main(String[] args) {

        String[][] relation = {
                {"Naveen", "Satish"},
                {"Satish", "Anushree"},
                {"Satish", "Sandeep"},
                {"Gurinder", "Naveen"}
        };

        System.out.println(organizationHierarchy(relation, 5));
    }

    private static List<String> organizationHierarchy(String[][] relation, int n) {
        //topological dfs stack rec
        HashMap<String, List<String>> graph = new HashMap<>();
        Stack<String> stack = new Stack<>();
        HashSet<String> vis = new HashSet<>();
        HashSet<String> totalEmployee = new HashSet<>();

        for (int i = 0; i < relation.length; i++) {
            graph.computeIfAbsent(relation[i][0], (k)->new ArrayList<>()).add(relation[i][1]);
            totalEmployee.add(relation[i][0]);
            totalEmployee.add(relation[i][1]);
        }

        for(String emp : totalEmployee){
            if(!vis.contains(emp)){
                topo(graph, vis, stack, emp);
            }
        }

        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());  // Pop to get correct topological order
        }
        return result;
    }

    private static void topo(HashMap<String, List<String>> graph, HashSet<String> vis,
                             Stack<String> stack, String curr) {

        vis.add(curr);
        if(graph.containsKey(curr)){
            for(String nextEmp : graph.get(curr)){
                if(!vis.contains(nextEmp)){
                    topo(graph, vis, stack, nextEmp);
                }
            }
        }
        stack.push(curr);
    }
}
