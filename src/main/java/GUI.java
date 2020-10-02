import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import static java.awt.BorderLayout.*;



public class GUI implements ActionListener {

    private JLabel label;
    private int trackIndexP1 ;
    private int trackIndexP2;
    public final JFrame mainFrame;
    private final JPanel buttonsPanel;
    private JLabel playerOneLabel;
    private JLabel playerTwoLabel;
    private JButton start;
    private JButton playerOneDice;
    private JButton playerTwoDice;
    private JPanel playerOnePanel;
    private JPanel playerTwoPanel;
    int p1_clickCounter = 0;
    int p2_clickCounter = 0;
    private static final int SNAKE1_HEAD = 17;
    private static final int SNAKE2_HEAD = 26;
    private static final int SNAKE1_TAIL = 9;
    private static final int SNAKE2_TAIL = 22;
    private static final int LADDER1_FIRST_STEP = 7;
    private static final int LADDER1_LAST_STEP = 19;
    private static final int LADDER2_FIRST_STEP = 16;
    private static final int LADDER2_LAST_STEP = 28;
    private JLabel player1Token;
    private JLabel player2Token;


    private ArrayList<JButton>buttons;



    public GUI(){
        this.player1Token = new JLabel();
        this.player1Token.setIcon(new ImageIcon("src/main/resources/horse.png"));
        this.player2Token = new JLabel();
        this.trackIndexP1 = 0; //Position of player1
        this.trackIndexP2 = 0; //Position of player2;
        this.start = new JButton();
        this.playerOneDice = new JButton();
        playerOneDice.setEnabled(false);
        this.label=new JLabel();
        label.setOpaque(true); //to make paint visible
        label.setBackground(Color.GREEN);
        label.setBorder(new BevelBorder(BevelBorder.RAISED));
        label.setBorder(BorderFactory.createEtchedBorder());

        label.setText("Snake and Ladder");

        label.setFont(new Font("Broadway", Font.ITALIC, 50));

        ImageIcon image = new ImageIcon("src/main/resources/title.png");
        label.setIcon(image);


        this.mainFrame = new JFrame();
        this.buttonsPanel = new JPanel(new GridLayout(6,6,5,5));
        this.buttons = new ArrayList<>();

        buttonsPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
    public void initGUI(){


        EventQueue.invokeLater(()->{

            colorButtons();


            mainFrame.getRootPane().setBorder(new BevelBorder(BevelBorder.RAISED));
            mainFrame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black,5,true));

        });



        this.mainFrame.setSize(900,900);
        mainFrame.setResizable(true);
        this.mainFrame.setVisible(true);
        this.mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        setButtonsPanel();
        mainFrame.add(label,NORTH);
        mainFrame.add(label,NORTH);



        //  this.minFrame.pack();
        buttonsPanel.setPreferredSize(new Dimension(700, 700));
        buttonsPanel.setBorder(BorderFactory.createEtchedBorder());
        //buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE,2,true));

        buttonsPanel.setBackground(Color.black);

    }
    public void setButtonsPanel(){

        for(int i = 36;i>0;i--){
            //creates JButtons and fills button with it
            buttons.add(new JButton(""+i));
            buttonsPanel.add(buttons.get(buttons.size()-1));
            buttons.get(buttons.size()-1).setBorder(new BevelBorder(BevelBorder.RAISED) );
           // buttons.get(buttons.size()-1).setBorder(BorderFactory.createLineBorder(Color.GREEN,1,true));
            buttons.get(buttons.size()-1).setBackground(Color.ORANGE);
          //  buttons.get(buttons.size()-1).setLayout(new GridLayout(1,1,1,1));
            buttons.get(buttons.size()-1).setFont(new Font("Broadway", Font.ITALIC, 40));


        }
        mainFrame.add(buttonsPanel);


    }

    private int setIndexPlayer1(int trackIndexP1){
        this.trackIndexP1 = trackIndexP1;
        return this.trackIndexP1;

    }
    private int setIndexPlayer2(int trackIndexP2){
        this.trackIndexP2 = trackIndexP2;
        return this.trackIndexP2;

    }

private void colorButtons()
{buttons.get(buttons.size()-1).setFont(new Font("Broadway", Font.ITALIC, 20));
buttons.get(0).setFont(new Font("Broadway", Font.ITALIC, 20));

buttons.get(35).setText("FINISH");
buttons.get(0).setText("START");
try { for (int i = 1; i < buttons.size(); i +=5) {
                buttons.get(i+1).setBackground(Color.GRAY);
                buttons.get(i + 2).setBackground(Color.CYAN);
                buttons.get(i + 3).setBackground(Color.BLACK);
                buttons.get(i+2/3).setBackground(Color.getHSBColor(.4F,.4F,.4F));

            }
        }catch (IndexOutOfBoundsException iob){
            System.out.println(iob);
        }
}


public void reverse(){ Collections.reverse(buttons);
}

public void setLadderAndSnake(){
        buttons.get(26).setText("");
        buttons.get(26).setIcon(new ImageIcon("src/main/resources/head.png"));
        buttons.get(20).setText("");


        buttons.get(20).setIcon(new ImageIcon("src/main/resources/bodyy.png"));
        buttons.get(21).setIcon(new ImageIcon("src/main/resources/tail.png"));
        buttons.get(21).setText("");
        buttons.get(17).setText(" ");
        buttons.get(17).setIcon(new ImageIcon("src/main/resources/head2.png"));
        buttons.get(11).setText(" ");
        buttons.get(11).setIcon(new ImageIcon("src/main/resources/body2.png"));
        buttons.get(10).setText("");
        buttons.get(10).setIcon(new ImageIcon("src/main/resources/tail3.png"));
        // buttons.get(6).setIcon(new ImageIcon("src/main/resources/ladder.png" +
        //  ""));

}

//Sets the Start button
public JButton setStartButton(){
        this.start.setBackground(Color.GREEN);
        this.start.setBorder(BorderFactory.createEtchedBorder());

        this.start.setIcon(new ImageIcon("src/main/resources/start.png"));
        mainFrame.add(this.start,SOUTH);
        System.out.println("Ajaaaab");
        return this.start;

}

public JButton setPlayerOnePanel(){
        this.playerOneDice.setIcon(new ImageIcon("src/main/resources/dice4.png"));
        this.playerOneDice.setFont(new Font("Broadway", Font.BOLD, 12));
        this.playerOnePanel = new JPanel(new GridLayout(2,1));
        this.playerOneLabel = new JLabel("ABDI");
        this.playerOneLabel.setIcon(new ImageIcon("src/main/resources/horse.png"));

        playerOnePanel.add(playerOneLabel);
        playerOnePanel.add(playerOneDice);
        playerOneDice.setBackground(Color.green);

        playerOnePanel.setBackground(Color.green);
        playerOnePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        playerOnePanel.setBorder(BorderFactory.createLineBorder(Color.RED,2,true));
        mainFrame.add(playerOnePanel,EAST);
        //playerOnePanel.setOpaque(true);


        return this.playerOneDice;
}
public JButton setPlayerTwoPanel(){
        playerTwoLabel = new JLabel("PC");
        label.setForeground(Color.red);
        mainFrame.add(playerTwoLabel,WEST);
        playerTwoDice = new JButton("Roll Dice p2");
        playerTwoDice.setBackground(Color.green);
        playerTwoPanel = new JPanel(new GridLayout(2,1));
        playerTwoPanel.setOpaque(true);

        playerTwoPanel.setBackground(Color.green);
        playerTwoPanel.setBorder(BorderFactory.createLineBorder(Color.RED,2,true));
        playerTwoPanel.add(playerTwoLabel);
        playerTwoPanel.add(playerTwoDice);
        mainFrame.add(playerTwoPanel,WEST);
        playerTwoDice.setEnabled(false);
        return playerTwoDice;

}

    public void setUpActionListener(){
        start.addActionListener(this::actionPerformed);
        playerOneDice.addActionListener(this::actionPerformed);
        playerTwoDice.addActionListener(this::actionPerformed);

    }
    public void reset(){
        trackIndexP1 = 0;
        trackIndexP2 = 0;
        buttons.get(trackIndexP1).add(player1Token);
        buttons.get(trackIndexP1).add(player2Token);
        setIndexPlayer1(0);
        setIndexPlayer2(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon imageIcon1 = new ImageIcon("src/main/resources/dice1.png");
        ImageIcon imageIcon2 = new ImageIcon("src/main/resources/dice2.png");
        ImageIcon imageIcon3 = new ImageIcon("src/main/resources/dice3.png");
        ImageIcon imageIcon4 = new ImageIcon("src/main/resources/dice4.png");
        ImageIcon imageIcon5 = new ImageIcon("src/main/resources/dice5.png");
        ImageIcon imageIcon6 = new ImageIcon("src/main/resources/dice.png");

        if(e.getSource()==setStartButton()){
            reset();

            this.playerTwoDice.setEnabled(true);
            this.playerOneDice.setEnabled(true);
            this.p1_clickCounter = 0;
            this.p2_clickCounter = 0;

        }else if(e.getSource()==playerOneDice){
            PlayerOne playerOne = new PlayerOne();
            PlayerTwo playerTwo = new PlayerTwo();
            playerTwoDice.setEnabled(false);
            p1_clickCounter++;
            p2_clickCounter = 0;
            playerTwo.reset();
            int dice1 = playerOne.getDiceOne();
            int dice2 = playerOne.getDiceTwo();

            if(p1_clickCounter==1){

                //int sum = dice1+dice2;
                switch (dice1){
                    case 1:
                        playerOneDice.setIcon(imageIcon1);
                        System.out.println(dice1); break;
                    case 2:
                        playerOneDice.setIcon(imageIcon2);
                        System.out.println(dice1); break;

                    case 3:
                        playerOneDice.setIcon(imageIcon3);
                        System.out.println(dice1); break;

                    case 4:
                        playerOneDice.setIcon(imageIcon4);System.out.println(dice1); break;
                    case 5:
                        playerOneDice.setIcon(imageIcon5);System.out.println(dice1); break;
                    case 6:
                        playerOneDice.setIcon(imageIcon6);System.out.println(dice1);
                }
            } else {

                switch (dice2){
                    case 1:
                        playerOneDice.setIcon(imageIcon1);
                        System.out.println(dice2); break;
                    case 2:
                        playerOneDice.setIcon(imageIcon2); System.out.println(dice2);break;
                    case 3:
                        playerOneDice.setIcon(imageIcon3); System.out.println(dice2);break;
                    case 4:
                        playerOneDice.setIcon(imageIcon4); System.out.println(dice2);break;
                    case 5:
                        playerOneDice.setIcon(imageIcon5); System.out.println(dice2);break;
                    case 6:
                        playerOneDice.setIcon(imageIcon6);System.out.println(dice2);break;
                }

                buttons.get(trackIndexP1+playerOne.getSumOfDice()).add(player1Token);
                System.out.println(" SUM: "+ playerOne.getSumOfDice());
                setIndexPlayer1(trackIndexP1+playerOne.getSumOfDice());

            }

            if(p1_clickCounter>=2){
                playerOneDice.setEnabled(false);
                playerTwoDice.setEnabled(true);
                playerOne.reset();

            }

        }else if (e.getSource()==playerTwoDice){
            PlayerOne playerOne = new PlayerOne();
            playerOneDice.setEnabled(false);
            p2_clickCounter++;
            p1_clickCounter = 0;
            if(p2_clickCounter>=2){
                playerTwoDice.setEnabled(false);
                playerOneDice.setEnabled(true);
                playerOne.reset();


            }
        }

    }
}
