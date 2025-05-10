package leetcode.dailyquestion;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinTimeToReach3342 {
    public static void main(String[] args) {

        int[][] moveTime = {{0, 4}, {4, 4}};
        int[][] moveTime1 = {{1, 0, 89}, {86, 61, 11}};
        System.out.println(minTimeToReach(moveTime1));
    }

    public static int minTimeToReach(int[][] moveTime) {
        //Dikstra's shortest path
        int n = moveTime.length;
        int m = moveTime[0].length;
        int moveCount = 0;
        int[][] timeArr = new int[n][m];
        for (int[] row : timeArr) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        timeArr[0][0] = 0;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // down,up, right, left
        PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        queue.offer(new Edge(0, 0, 0, 0));

        while (!queue.isEmpty()) {

            Edge curr = queue.poll();
            int i = curr.i, j = curr.j, step = curr.steps;
            // move in all 4 direction, every alternate move is 2 (+1, +2)
            for (int k = 0; k < dir.length; k++) {
                int i1 = i + dir[k][0];
                int j1 = j + dir[k][1];
                if (0 <= i1 && i1 < n && 0 <= j1 && j1 < m) {

                    int nextTime = curr.time;
                    if (nextTime < moveTime[i1][j1]) {
                        nextTime = moveTime[i1][j1];
                    }
                    nextTime += (step) % 2 == 0 ? 1 :2;
                    if (nextTime < timeArr[i1][j1]) {
                        timeArr[i1][j1] = nextTime;
                        queue.offer(new Edge(i1, j1, nextTime, step+1));
                    }
                }
            }
        }

        return timeArr[n - 1][m - 1];
    }

    static class Edge {
        int i;
        int j;
        int time;
        int steps;

        public Edge(int i, int j, int time, int steps) {
            this.i = i;
            this.j = j;
            this.time = time;
            this.steps = steps;
        }
    }
}
