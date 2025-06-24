package leetcode.dailyquestion;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;

public class ShortestPathLength847 {

    public static void main(String[] args) {

    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int path = 0;
        Queue<Pair> queue = new ArrayDeque<>();
        HashSet<Pair> visited = new HashSet<>();
        int allNodeVisited = (int) (Math.pow(2, n) - 1);

        for (int i = 0; i < n; i++) {
            int bitMask = 1 << i;
            Pair p = new Pair(i, bitMask);
            queue.offer(p);
            visited.add(p);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            for (int i = 0; i < size; i++) {
                Pair currNode = queue.poll();

                for (int j = 0; j < graph[currNode.node].length; j++) {
                    int neighbour = graph[currNode.node][j];
                    int neighbourMask = 1 << neighbour | currNode.bitMask;
                    Pair p = new Pair(neighbour, neighbourMask);
                    if (!visited.contains(p)) {
                        queue.offer(p);
                        visited.add(p);
                    }
                    if (neighbourMask == allNodeVisited) {
                        return path;
                    }
                }
            }
        }
        return -1;
    }

    class Pair {
        int node;
        int bitMask;

        public Pair(int node, int bitMask) {
            this.node = node;
            this.bitMask = bitMask;
        }

        public int getNode() {
            return node;
        }

        public int getBitMask() {
            return bitMask;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public void setBitMask(int bitMask) {
            this.bitMask = bitMask;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return node == pair.node && bitMask == pair.bitMask;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, bitMask);
        }
    }

}
