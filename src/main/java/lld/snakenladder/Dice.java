package lld.snakenladder;

import java.util.Random;

public class Dice {

    private int diceCount ;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice(){
        int diceSum =0;
        for (int i = 0; i < diceCount; i++) {
            diceSum+= new Random().nextInt(6)+1;
        }
        return diceSum;
    }
}
