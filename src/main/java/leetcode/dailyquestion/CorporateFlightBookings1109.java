package leetcode.dailyquestion;

import java.util.Arrays;

public class CorporateFlightBookings1109 {

    public static void main(String[] args) {

      int [][] bookings = {{1,2,10},{2,3,20},{2,5,25}};
      int n = 5;
        System.out.println(Arrays.toString(corpFlightBookings(bookings, n)));
      //Output: [10,55,45,25,25]
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {

        int [] ans = new int[n];

        for (int i = 0; i < bookings.length; i++) {

            for (int j = bookings[i][0]-1; j <bookings[i][1]; j++) {
                ans[j]+=bookings[i][2];
            }
        }
        return ans;
    }
}
