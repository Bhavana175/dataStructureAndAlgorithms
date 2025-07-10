package leetcode.dailyquestion;


import java.util.PriorityQueue;

public class RescheduleMeetingsMaxFreeTime_II_3440 {
    public static void main(String[] args) {
        int eventTime = 10;
        int[] startTime = {0, 3, 7, 9}, endTime = {1, 4, 8, 10};
        System.out.println(maxFreeTime(eventTime, startTime, endTime));
    }

    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {

        int n = startTime.length;
        int[] gap = new int[n + 1];

        gap[0] = startTime[0];
        for (int i = 1; i < n; i++) {
            gap[i] = startTime[i] - endTime[i - 1];
        }
        gap[n] = eventTime - endTime[n - 1];

        // maintain to 3 gap, and try to insert meeting in , corner case possible 2 adj gap, 1 non adj
        PriorityQueue<int[]> topThreeSpace = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < n+1; i++) {
            if (topThreeSpace.size() < 3) {
                topThreeSpace.offer(new int[]{gap[i], i});
            } else if (topThreeSpace.peek()[0] < gap[i]) {
                topThreeSpace.poll();
                topThreeSpace.add(new int[]{gap[i], i});
            }
        }

        int maxFreeTime = 0;

        for (int i = 0; i < n; i++) {

            int meetingDuration = endTime[i] - startTime[i];
            int change = 0;
            // try placing this meeting into top 3 gaps
            for (int[] pair : topThreeSpace) {

                int gapLen = pair[0];
                int gapIndex = pair[1];

                if (gapIndex == i || gapIndex == i + 1) continue;

                if (meetingDuration <= gapLen) {
                    change = 1;
                    maxFreeTime = Math.max(maxFreeTime, gap[i] + gap[i + 1] + meetingDuration);
                    break;
                }
            }

            if (change == 0) {
                maxFreeTime = Math.max(maxFreeTime, gap[i] + gap[i + 1]);
            }
        }

        return maxFreeTime;
    }

}
