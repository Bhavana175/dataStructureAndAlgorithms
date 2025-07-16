package leetcode.dailyquestion.booking_practice;

import java.util.*;

public class RewardTopKStudents_2512 {
    public static void main(String[] args) {
        String[] positive_feedback = {"smart", "brilliant", "studious"};
        String[] negative_feedback = {"not"};
        String[] report = {"this student is studious", "the student is smart"};
        int[] student_id = {1, 2};
        int k = 2;
        // Output: [2,1]
        System.out.println(topStudents(positive_feedback,negative_feedback, report, student_id, k));
    }

    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {

        List<Integer> topRankStudentList = new ArrayList<>();

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o2[1] == o1[1]) {
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });

        HashSet<String> positiveSet = new HashSet<>(Arrays.asList(positive_feedback));
        HashSet<String> negativeSet = new HashSet<>(Arrays.asList(negative_feedback));

        for (int i = 0; i < student_id.length; i++) {
            String feedback = report[i];
            String[] str = feedback.split(" ");
            int points =0;
            for (String word : str) {
                if (positiveSet.contains(word)) {
                    points += 3;
                }
                if (negativeSet.contains(word)) {
                    points -= 1;
                }
            }
            priorityQueue.offer(new int []{student_id[i], points});
        }

        while (! priorityQueue.isEmpty() && k>0){
            topRankStudentList.add(priorityQueue.poll()[0]);
            k--;
        }

        return topRankStudentList;
    }
}
