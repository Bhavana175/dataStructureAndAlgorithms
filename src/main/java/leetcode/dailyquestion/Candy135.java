package leetcode.dailyquestion;

import java.util.Arrays;

public class Candy135 {
    public static void main(String[] args) {

        int[] ratings = {1, 2, 3, 1, 4, 5}; // 12
        int[] ratings2 = {1, 2, 87, 87, 87, 2, 1}; // 13
        System.out.println(candy(ratings));
        System.out.println(candy(ratings2));
    }

    public static int candy(int[] ratings) {

        int length = ratings.length;
        int minCandy = 0;
        int[] candy = new int[length];
        Arrays.fill(candy, 1);

        for (int i = 1; i < length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            }
        }

        for (int c : candy){
            minCandy+=c;
        }

        return minCandy;
    }
}
