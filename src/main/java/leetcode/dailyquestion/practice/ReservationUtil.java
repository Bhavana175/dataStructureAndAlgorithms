package leetcode.dailyquestion.practice;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class ReservationUtil {

    public static void main(String[] args) {

        List<Reservation> reservationList = Arrays.asList(
                new Reservation(1, 0,9),
                new Reservation(12, 9,12),
                new Reservation(123, 3,11),
                new Reservation(13, 7,14)
        );

        System.out.println(new ReservationUtil().getListOfDaysBelowThreshold(reservationList));

    }

    public List<Integer> getListOfDaysBelowThreshold(List<Reservation> reservationList){

        TreeMap<Integer, Integer> freMap = new TreeMap<>();
        List<Integer> output = new ArrayList<>();
        // m * nlog(n)
        for (Reservation res: reservationList){
            for (int i = res.checkIn; i < res.checkOut; i++) {
                freMap.put(i, freMap.getOrDefault(i,0)+1);
            }
        }

        int startDate = freMap.firstKey();
        int endDate = freMap.lastKey();
        // O(n)
        for (int i = startDate; i <=endDate ; i++) {

            int currDate = i;
            int avg = 0;
            for (int j = currDate-7; j < currDate; j++) {
                if(freMap.containsKey(j)){
                    avg+=freMap.get(j);
                }
            }

            double threshold = (avg/(double)7)* (double) 0.80;
            if(freMap.get(currDate)<threshold){
                output.add(currDate);
            }

        }// n + (m*n log n) => O(m*nlog(n));
        return output;
    }

    @AllArgsConstructor
    static class Reservation{

        int id;
        int checkIn;
        int checkOut;
    }

}
