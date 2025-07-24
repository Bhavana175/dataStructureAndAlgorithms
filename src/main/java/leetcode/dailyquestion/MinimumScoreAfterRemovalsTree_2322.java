package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumScoreAfterRemovalsTree_2322 {
    public static void main(String[] args) {

    }

    public int minimumScore(int[] nums, int[][] edges) {

        int n = nums.length;
        List<Integer>[] adjList = new List[n];
        int[] xor = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        int totalXOR = dfsCalculateXOR(0, -1, nums, xor, parent, adjList);
        int minScore = Integer.MAX_VALUE;
        // as xor for each node calculated
        // now break component , we need to remove 2 edges to have 3 components  c1,c2,c3

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int a = xor[i];
                int b = xor[j];
                int c; // third component xor

                if (isAncestor(i, j, parent)) {
                    c = totalXOR ^ a;
                    a = a ^ b;
                } else if (isAncestor(j, i, parent)) {
                    c = totalXOR ^ b;
                    b = b ^ a;
                } else {
                    //disjoint
                    c = totalXOR ^ a ^ b;
                }

                int max = Math.max(a, Math.max(b, c));
                int min = Math.min(a, Math.min(b, c));
                minScore = Math.min(minScore, max - min);

            }
        }
        return minScore;
    }

    private boolean isAncestor(int ancestor, int node, int[] parent) {
        while (node != -1) {
            if (node == ancestor) return true;
            node = parent[node];// go up
        }
        return false;
    }

    private int dfsCalculateXOR(int currNode, int parentNode, int[] nums, int[] xor, int[] parent, List<Integer>[] adjList) {

        xor[currNode] = nums[currNode];
        parent[currNode] = parentNode;

        for (int i = 0; i < adjList[currNode].size(); i++) {
            int nei = adjList[currNode].get(i);
            if (nei != parentNode) {
                xor[currNode] ^= dfsCalculateXOR(nei, currNode, nums, xor, parent, adjList);
            }
        }
        return xor[currNode];
    }
}
