package leetcode.dailyquestion;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;

public class ShortestPathVisitingAllNodes847 {

    public static void main(String[] args) {
        int [][] graph = {{1,2,3},{0},{0},{0}};
        ShortestPathVisitingAllNodes847 obj = new ShortestPathVisitingAllNodes847();
        System.out.println(obj.shortestPathLength(graph));
    }

    private class Pair{
        int node;
        int masked;

        public Pair(int node, int masked) {
            this.masked = masked;
            this.node = node;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getMasked() {
            return masked;
        }

        public void setMasked(int masked) {
            this.masked = masked;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return node == pair.node && masked == pair.masked;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, masked);
        }
    }

    public int shortestPathLength(int[][] graph) {
        // path that visits every node
        int n= graph.length;

        if(n==0 || n==1){
            return 0;
        }

        HashSet<Pair> visited = new HashSet<>();
        Queue<Pair> queue = new ArrayDeque<>();
        int allVisited = (int)Math.pow(2,n)-1 ;
        int path =0;

        //create mask for each node and add into queue
        for (int i = 0; i < n; i++) {
            int masked = 1<<i;
            Pair p= new Pair(i, masked);
            queue.offer(p);
            visited.add(p);
        }


        while (!queue.isEmpty()){
            path++;
            int size = queue.size();
            // for each node visit adj node
            for (int j = 0; j < size; j++) {
               Pair curr = queue.poll();
               for (int i = 0; i < graph[curr.node].length; i++) {
                   int adjNode = graph[curr.node][i];
                   int adjMask =( 1<<adjNode) | (curr.masked);
                   Pair adjPair = new Pair(adjNode, adjMask);
                   if(!visited.contains(adjPair)){
                       visited.add(adjPair);
                       queue.add(adjPair);
                   }
                   if(allVisited==adjMask){
                       return path;
                   }
               }
               size--;
           }
        }
        return -1;
    }

}
