package leetcode.dailyquestion;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxNumberOfEventCanBeAttended_1353 {
    public static void main(String[] args) {
        int[][] events = {{1, 2}, {2, 3}, {3, 4}, {1, 5}};
        System.out.println(maxEvents(events));
    }

    public static int maxEvents(int[][] events) {

        // timeline
        // sort events by start date , and end date attend shorter event first

        int n = events.length;
        int i = 0;

     /*   Arrays.sort(events, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });*/

        Arrays.sort(events, (o1,o2)->o1[0]-o2[0]);

        int day = events[0][0];
        int count = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (!pq.isEmpty() || i < n) {

            while (i < n && day == events[i][0]) {
                pq.offer(events[i][1]);
                i++;
            }

            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
            day++;
            while (!pq.isEmpty() && pq.peek() > day) {
                pq.remove();
            }
        }
        return count;
    }
}
