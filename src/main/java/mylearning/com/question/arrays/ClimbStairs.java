package mylearning.com.question.arrays;

public class ClimbStairs {
/*
    You are climbing a staircase. It takes n steps to reach the top.
    Each time you can either climb 1 or 2 steps.
    In how many distinct ways can you climb to the top?
    Example 1:
    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps
    */

    public int climbStairs(int n) {
        int ways = 0;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int p1 = 1, p2 = 2;

        for (int i = 3; i <= n; i++) {

            //number of ways equal to sum of number of ways for previous step
            ways = p1 + p2;
            p1 = p2;
            p2 = ways;

        }

        return p2;

    }

}
