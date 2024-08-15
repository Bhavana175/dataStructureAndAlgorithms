package com.workspace.learning.datastructure.graph;

public class ConnectedGraphUnionProblem {
    /*
    https://leetcode.com/problems/number-of-provinces/description/
    https://www.youtube.com/watch?v=8f1XPm4WOUc&ab_channel=NeetCode
     */

    public static void main(String[] args) {

      //  int [][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int [][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};

        System.out.println(findCircleNum(isConnected));


    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        int res = n;
        int [] parent = new int[n];
        int [] rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i]=i;
            rank[i]=1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(isConnected[i][j]==1){
                    res -= performUnion(i, j, rank,parent);
                }
            }
        }
        if(res==0){
            return 1;
        }
        return res;
    }

    private static int performUnion(int i, int j, int[] rank, int [] parent) {
        int pi = getParentNode(parent, i);
        int pj = getParentNode(parent, j);
        if(pi==pj){
            return 0;
        }
        if(rank[pi]>rank[pj]){
            parent[pj]=pi;
            rank[pi]+=rank[pj];
        }else {
            parent[pi]=pj;
            rank[pj]+=rank[pi];
        }
        return 1;
    }

    private static int getParentNode(int[] parent, int node) {
        while (node != parent[node]) {
           node = parent[parent[node]];
        }
        return node;
    }

}
