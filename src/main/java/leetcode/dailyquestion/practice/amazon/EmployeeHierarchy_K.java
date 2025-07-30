package leetcode.dailyquestion.practice.amazon;

import java.util.*;

public class EmployeeHierarchy_K {
    public static void main(String[] args) {
        int[][] input = {
                {1, 5},
                {2, 5},
                {3, 6},
                {4, 6},
                {5, 7},
                {6, 7},
                {7, -1}
        };
        System.out.println(getHierarchyPath(input, 5));
        System.out.println(getHierarchyPath(input, 3));
        System.out.println(getHierarchyPath(input, 1));
        System.out.println();
        //impl 2
        Node root = buildTree(input);
        System.out.println(getHierarchyPathWithNode(root, 5));
    }
    public static List<Integer> getHierarchyPathWithNode(Node root, int empId) {

        List<Integer> path = new ArrayList<>();
        dfs(root, empId, path);
        Collections.reverse(path);
        return path;
    }

    private static boolean dfs(Node currNode, int empId, List<Integer> path) {

        if(currNode == null){
            return false;
        }

        path.add(currNode.val);
        if(currNode.val == empId) return true;
        if(dfs(currNode.left, empId, path) || dfs(currNode.right, empId, path)){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static List<Integer> getHierarchyPath(int[][] input, int empId) {

        HashMap<Integer, Integer> reportsToMap = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            reportsToMap.put(input[i][0], input[i][1]);
        }

        List<Integer> path = new ArrayList<>();
        int curr = empId;

        while (curr != -1) {
            path.add(curr);
            curr = reportsToMap.getOrDefault(curr, -1);
        }

        return path;
    }

    public static Node buildTree(int[][] input) {

        HashMap<Integer, Node> nodeMap = new HashMap<>();
        HashMap<Integer, List<Integer>> mgrToEmp = new HashMap<>();
        int rootId = -1;
        for (int i = 0; i < input.length; i++) {
            int emp = input[i][0];
            int mgr = input[i][1];

            nodeMap.putIfAbsent(emp, new Node(emp));
            if (mgr == -1) {
                rootId = emp;
                nodeMap.putIfAbsent(rootId, new Node(rootId));
            } else {
                nodeMap.putIfAbsent(mgr, new Node(mgr));
                mgrToEmp.computeIfAbsent(mgr, (k) -> new ArrayList<>()).add(emp);
            }

            //connect children to mgr
            for (Map.Entry<Integer, List<Integer>> entry : mgrToEmp.entrySet()) {
                int key = entry.getKey();
                Node mgr_key = nodeMap.get(key);
                List<Integer> reportees = entry.getValue();
                if (!reportees.isEmpty()) mgr_key.left = nodeMap.get(reportees.get(0));
                if (reportees.size() > 1) mgr_key.right = nodeMap.get(reportees.get(1));
            }

        }
        return nodeMap.get(rootId);
    }


}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}