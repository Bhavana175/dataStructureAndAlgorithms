package leetcode.dailyquestion.practice.amazon;

import java.util.HashMap;

public class AmazonBoxDelivery_K {
    public static void main(String[] args) {
        int[] boxes1 = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        System.out.println(minimumRounds(boxes1)); // Output: 4

        int[] boxes2 = {2, 3, 3};
        System.out.println(minimumRounds(boxes2)); // Output: -1
    }

    private static int minimumRounds(int[] boxes) {

        HashMap<Integer, Integer> freq = new HashMap<>();
        int round =0;

        for (int i = 0; i < boxes.length; i++) {
            freq.put(boxes[i], freq.getOrDefault(boxes[i], 0)+1);
        }

        for (int box: freq.keySet()){
            if(freq.get(box)==1) return -1;

            int boxCount = freq.get(box);
            if(boxCount % 3 ==0){
                round += boxCount/3;
            }else {
                round += boxCount /3 +1;
            }
        }

        return round;
    }


}
