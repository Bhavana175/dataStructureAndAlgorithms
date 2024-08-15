package mylearning.com.interviewmanhattan2;

/*

suppose i have to write a method

ths input of this method will be a positive integer
[2:37 PM] Ashim Kumar
the method shoudl tell us whether the input is a perfect squar or not
[2:37 PM] Ashim Kumar
e.g. 49 -> 7*7
[2:37 PM] Ashim Kumar
48 is not a perfect square
 */

import static java.lang.Math.floor;

public class Solution {

    public static void main(String[] args) {

        boolean perfectSquare = isPerfectSquare(48);
        System.out.println(perfectSquare);

    }

    public static boolean isPerfectSquare(double num){
        // num = 49
        double sqrt = Math.sqrt(num);
        if(floor(sqrt)==sqrt){
            return true;
        }
        return false;
    }

}
