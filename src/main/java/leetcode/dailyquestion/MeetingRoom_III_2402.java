package leetcode.dailyquestion;

import java.util.*;

public class MeetingRoom_III_2402 {
    public static void main(String[] args) {
        int n = 3;
        int[][] meetings = {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}};
        System.out.println(mostBooked(n, meetings));
    }

    private static int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (o1,o2)->o1[0]-o2[0]);
        //smaller room number will be at start
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>(((o1, o2) -> o1 - o2));
        // endTime and room number
       // PriorityQueue<long[]> busyRooms = new PriorityQueue<>((o1,o2)->Long.compare(o1[0],o2[0]));
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
                (o1, o2) -> o1[0] == o2[0] ? Long.compare(o1[1], o2[1]) : Long.compare(o1[0], o2[0])
        );
        int[] roomCount = new int[n];

        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                long[] freeUpRoom = busyRooms.poll();
                freeRooms.offer((int)freeUpRoom[1]);
            }
            if (!freeRooms.isEmpty()) {
                int roomNum = freeRooms.poll();
                busyRooms.offer(new long[]{end, roomNum});
                roomCount[roomNum]++;
            } else {
                long[] nextFreeTime = busyRooms.poll();
                busyRooms.offer(new long[]{(end - start) + nextFreeTime[0], nextFreeTime[1]});
                roomCount[(int)nextFreeTime[1]]++;
            }

        }
        int maxCount = 0, roomNumber = 0;
        for (int i = 0; i < n; i++) {
            if (maxCount < roomCount[i]) {
                maxCount = roomCount[i];
                roomNumber = i;
            }
        }
        return roomNumber;
    }

    // time complexity is very large O(T*N*M) (T : end time, n : num of rooms, m: meetings )
    public static int mostBookedHashMap(int n, int[][] meetings) {
        // assumption : meetings in sorted order with start time
        int endTime = 0;
        for (int i = 0; i < meetings.length; i++) {
            endTime = Math.max(endTime, meetings[i][1]);
        }

        HashMap<Integer, List<int[]>> roomOccupancyMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            roomOccupancyMap.put(i, new ArrayList<>());
        }

        int currTime = 0;
        while (currTime <= endTime) {

            for (int i = 0; i < meetings.length; i++) {
                if (currTime == meetings[i][0]) {
                    boolean isMeetingPostponed = true;
                    for (Map.Entry<Integer, List<int[]>> room : roomOccupancyMap.entrySet()) {
                        if (room.getValue().isEmpty()) {
                            isMeetingPostponed = false;
                            room.getValue().add(new int[]{meetings[i][0], meetings[i][1]});
                            break;
                        } else {
                            int size = room.getValue().size();
                            if (room.getValue().get(size - 1)[1] <= currTime) {
                                isMeetingPostponed = false;
                                room.getValue().add(new int[]{meetings[i][0], meetings[i][1]});
                                break;
                            }
                        }
                    }

                    if (isMeetingPostponed) {
                        meetings[i][0] += 1;
                        meetings[i][1] += 1;
                        if (endTime < meetings[i][1]) {
                            endTime = meetings[i][1];
                        }
                    } else {
                        meetings[i][0] = -1;
                        meetings[i][1] = -1;
                    }
                }
            }
            currTime++;
        }
        int maxMeeting = 0;
        int roomNumber = 0;
        for (Map.Entry<Integer, List<int[]>> entry : roomOccupancyMap.entrySet()) {
            if (maxMeeting < entry.getValue().size()) {
                maxMeeting = entry.getValue().size();
                roomNumber = entry.getKey();
            }
        }
        return roomNumber;
    }
}
