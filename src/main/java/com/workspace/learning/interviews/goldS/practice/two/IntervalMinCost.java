package com.workspace.learning.interviews.goldS.practice.two;

import java.util.Arrays;


public class IntervalMinCost {

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(0, 5, 10),
                new Interval(2, 8, 15),
                new Interval(7, 10, 7)
        };

        int[] minCosts = getMinCostIntervals(intervals);

        for (int i = 0; i < minCosts.length; i++) {
            System.out.println("Hour " + i + ": " + minCosts[i]);
        }
    }

    private static int[] getMinCostIntervals(Interval[] intervals) {
        int[] minCosts = new int[24];
        Arrays.fill(minCosts, Integer.MAX_VALUE);

        for (Interval interval : intervals) {
            for (int i = interval.start; i < interval.end; i++) {
                minCosts[i] = Math.min(minCosts[i], interval.cost);
            }
        }

        return minCosts;
    }

    static class Interval {
        int start;
        int end;
        int cost;

        Interval(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
