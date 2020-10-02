public class Players {
    private String name;
    private int diceOne = 0;
    private int diceTwo = 0;
    private Dice dice1;
    private Dice dice2;
    public Dice dice;


    public Players() {
        this.dice = new Dice();
        this.dice1 = new Dice();
        this.dice2 = new Dice();
        this.diceOne = dice1.getRollDice();
        this.diceTwo = dice2.getRollDice();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiceOne() {
        return this.diceOne;
    }

    public int getDiceTwo() {
        return this.diceTwo;
    }


    public int getSumOfDice() {
        return this.diceOne + this.diceTwo;
    }
public void reset(){
        dice2.setRollDice(0);
        dice1.setRollDice(0);
}

}
