package com.workspace.learning.interviews.paypalpractice;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblemCircleSingingTeacher {

    //https://www.geeksforgeeks.org/josephus-problem/

/*    Josephus( list , start , k){
        if list.size = 1
        return list[0]
        start = (start + k) % list.size
        list.remove( start )
        return Josephus( list, start, k)*/

    public static void main(String[] args) {

        int numberOfStudent = 7;
        //k length of song
        int k = 3;

        int winnerPosition = findTheWinnerPosition(numberOfStudent, k);
        System.out.println("output :" + winnerPosition);

        int numberOfStudent1 = 14;
        //k length of song
        int k1 = 2;

        int winnerPosition1 = findTheWinnerPosition(numberOfStudent1, k1);
        System.out.println("output :" + winnerPosition1);
    }

    private static int findTheWinnerPosition(int numberOfStudent, int k) {

        List<Integer> studentList = new ArrayList<>();

        for (int i = 1; i <= numberOfStudent; i++) {
            studentList.add(i);
        }
        int index = 0;

        while (studentList.size() > 1) {
            index = (index + k - 1) % studentList.size();
            studentList.remove(index);

        }

        return studentList.size() == 1 ? studentList.get(0) : 0;

    }

}
