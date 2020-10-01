import java.util.Random;

import static java.lang.Math.random;

public class Dice {
    private static final int MAX = 6;
    private int rollDice;


    public Dice() {
    }


    public int SetRollDice(){
        this.rollDice =(int) ((random() * MAX) + 1);
        return rollDice;
    }
    public int getRollDice(){
        return this.rollDice;
    }
}
