package leetcode.dailyquestion;

import java.util.Arrays;

public class MaxMatchingPlayersWithTrainer_2410 {
    public static void main(String[] args) {
        int [] players = {4,7,9}, trainers = {2,5,8};
        System.out.println(matchPlayersAndTrainers(players,trainers));
    }
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0;
        int j=0;
        while (i<players.length && j <trainers.length){
            if(players[i]<=trainers[j]){
                i++;
            }
            j++;
        }
        return i;
    }
}
