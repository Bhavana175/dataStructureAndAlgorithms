package com.workspace.learning.interviews.goldmansachs.practice;

public class Power {
    public static void main(String[] args) {
        // Test cases
        System.out.println(power(2, 3));  // Output: 8
        System.out.println(power(3, 4));  // Output: 81
        System.out.println(power(5, 0));  // Output: 1
        System.out.println(power(2, -3)); // Output: 0.125
    }

    // Method to calculate power using an iterative approach
    public static double power(double base, int exp) {
        if (exp == 0) {
            return 1;
        }

        double result = 1;
        for (int i = 0; i < Math.abs(exp); i++) {
            result *= base;
        }

        // Handle negative exponents
        if (exp < 0) {
            return 1 / result;
        }
        return result;
    }
}
