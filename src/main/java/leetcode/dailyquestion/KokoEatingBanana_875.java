package leetcode.dailyquestion;

public class KokoEatingBanana_875 {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));

    }
    public static int minEatingSpeed(int[] piles, int h) {
        int k =0;
        int maxBanana = 0;
        for (int i = 0; i < piles.length; i++) {
            maxBanana = Math.max(maxBanana, piles[i]);
        }

        //speed in between 1 to maxBanana
        int lowerSpeed = 0;
        int higherSpeed = maxBanana;

        while (lowerSpeed<= higherSpeed){

            int midSpeed = (lowerSpeed+higherSpeed)/2;

            //time to eat all banana with midSpeed
            int totalTimeNeeded =0;
            for (int onePile: piles){
                totalTimeNeeded += Math.ceil((double) onePile / midSpeed);
            }

            if(totalTimeNeeded<=h){
                // we can go slow
                k = midSpeed;
                higherSpeed = midSpeed-1;
            }else lowerSpeed = midSpeed+1; // else go faster

        }

        return k;
    }
}
