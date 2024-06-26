package com.workspace.learning.interviews.goldS.practice.two;

import java.util.HashMap;
import java.util.Map;

public class HighestAvgScore {

    public static void main(String[] args) {

        String[][] scores = {{"jerry", "65" }, {"bob", "20" }, {"jerry", "23" }, {"Eric", "83" }};
        String output = getStudentNameWithHighestAvgScore(scores);
        System.out.println(output);

    }

    private static String getStudentNameWithHighestAvgScore(String[][] scores) {

        class StudentInfo {
            int sum = 0;
            int count = 0;
        }

        HashMap<String, StudentInfo> map = new HashMap<>();
        // n
        for (int i = 0; i < scores.length; i++) {

            StudentInfo studentInfo = map.computeIfAbsent(scores[i][0], k -> new StudentInfo());

            studentInfo.sum += Integer.parseInt(scores[i][1]);
            studentInfo.count++;

        }

        double maxAvg = 0.0;
        String topStudent = "";
        //m, m<n
        for (Map.Entry<String, StudentInfo> entry : map.entrySet()) {

            double avg = entry.getValue().sum / entry.getValue().count;

            if (avg > maxAvg) {
                maxAvg = avg;
                topStudent = entry.getKey();
            }

        }
        // time O(n+m) = O(n)
        // space O(m+n) = O(n)
        return topStudent;
    }

}
