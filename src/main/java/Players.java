public class Players {
    private String name;
    private int diceOne;
    private int diceTwo;
    private Dice dice;
    private boolean yourTurn;
    private int countClick;
    private int index;



    public Players() {
        this.dice = new Dice();
        this.countClick = 0;
        this.index = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiceOne() {
        return diceOne;
    }

    public int getDiceTwo() {
        return diceTwo;
    }

    public void setDiceTwo() {
       this.diceTwo = dice.SetRollDice();
    }
    public void setDiceOne() {
     this.diceOne =   dice.SetRollDice();
    }


    public int getSumOfDice() {
        return diceOne + diceTwo;
    }

    public boolean getYourTurn() {
        return yourTurn;
    }

    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }

    public int getCountClick() {
        return countClick;
    }
    public void setCountClick(){
        this.countClick++;


    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
public int sumOfDice(){
    return getDiceOne()+ getDiceTwo();
}
}
