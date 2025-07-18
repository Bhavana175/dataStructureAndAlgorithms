package leetcode.dailyquestion.booking_practice;

import java.util.*;

public class HotelBookingRollingAvg {
    public static void main(String[] args) {

        List<int[]> bookings = new ArrayList<>();
        double threshold = .5;

        bookings.add(new int[]{10, 2});
        bookings.add(new int[]{15, 4});
        bookings.add(new int[]{16, 1});
        bookings.add(new int[]{17, 1});
        bookings.add(new int[]{18, 2});
        bookings.add(new int[]{19, 2});

        System.out.println(findLowBookingDates(bookings, threshold, 3));
    }

    public static List<Integer> findLowBookingDates(List<int[]> bookings, double thresholdPercent, int windowSize) {

        // use treemap or just sort the bookings with date
        TreeMap<Integer, Integer> bookingMap = new TreeMap<>();
        int startDate = Integer.MAX_VALUE;
        int endDate = 0;

        for (int i = 0; i < bookings.size(); i++) {
            bookingMap.put(bookings.get(i)[0], bookingMap.getOrDefault(bookings.get(i)[0], 0) + bookings.get(i)[1]);
            startDate = Math.min(startDate, bookings.get(i)[0]);
            endDate = Math.max(endDate, bookings.get(i)[0]);
        }

        LinkedList<Integer> window = new LinkedList<>(); // store sum
        int sum = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = startDate; i <= endDate; i++) {

            int currDayBooking = bookingMap.getOrDefault(i, 0);

            sum += currDayBooking;
            window.add(currDayBooking);
            if (window.size() > windowSize) {
                sum -= window.removeFirst(); // remove first
            }
            if (window.size() == windowSize) {
                double avgSevenDaySum = (double) sum / windowSize;
                double thresholdBooking = thresholdPercent * avgSevenDaySum;
                if (currDayBooking < thresholdBooking) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}