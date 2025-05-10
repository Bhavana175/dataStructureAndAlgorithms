package leetcode.dailyquestion;


import java.util.PriorityQueue;

public class MinTimeToReach3341 {
    public static void main(String[] args) {
        int[][] moveTime = {{0, 4}, {4, 4}};
        int[][] moveTime2 = {{56, 93}, {3, 38}};
        int[][] moveTime3 = {{2, 1, 59}, {29, 57, 39}};
        //[[15,58],[67,4]]
        System.out.println(minTimeToReachRec(moveTime2)); // expected 39
    }

    //@AllArgsConstructor
    static class Edge {
        int i;
        int j;
        int time;

        public Edge(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public static int minTimeToReachRec(int[][] moveTime) {

        //Dikstra's  algo, priority queue and bfs, realization
        PriorityQueue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] timeArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                timeArr[i][j] = Integer.MAX_VALUE;
            }
        }
        timeArr[0][0] = 0;
        queue.offer(new Edge(0, 0, 0));

        while (!queue.isEmpty()) {

            Edge curr = queue.poll();
            int i = curr.i;
            int j = curr.j;
            if (0 < i) {
                int nextTime = Math.max(moveTime[i-1][j], curr.time)+1;
                if(timeArr[i-1][j]>nextTime){
                    timeArr[i-1][j]=nextTime;
                    queue.offer(new Edge(i-1, j , nextTime));
                }

            }
            if (0 < j) {
               int nextTime = Math.max(moveTime[i][j-1], curr.time)+1;
                if(timeArr[i][j-1]>nextTime){
                    timeArr[i][j-1]=nextTime;
                    queue.offer(new Edge(i, j - 1, nextTime));
                }
            }
            if (i < n - 1) {
                int nextTime = Math.max(moveTime[i+1][j], curr.time)+1;
                if(timeArr[i+1][j]>nextTime){
                    timeArr[i+1][j]=nextTime;
                    queue.offer(new Edge(i+1, j , nextTime));
                }
            }
            if (j < m - 1) {
                int nextTime = Math.max(moveTime[i][j+1], curr.time)+1;
                if(timeArr[i][j+1]>nextTime){
                    timeArr[i][j+1]=nextTime;
                    queue.offer(new Edge(i, j+1 , nextTime));
                }
            }
        }

        return timeArr[n - 1][m - 1];
    }

}
