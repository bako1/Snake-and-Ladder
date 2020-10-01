import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import static java.awt.BorderLayout.*;



public class GUI implements ActionListener {

    private JLabel label;
    private int trackIndex = 0;
    JPanel jp =  new JPanel(new BorderLayout());
    public final JFrame mainFrame;
    private final JPanel buttonsPanel;
    private JButton diceButton;
    private JLabel playerOneBut;
    private JLabel playerTwoBut;
    private JButton start;
    private JButton playerOneDice;
    private JButton playerTwoDice;
    private JPanel playerOnePanel;
    private JPanel playerTwoPanel;
    int click;
    int p1_clickCounter = 0;
    int p2_clickCounter = 0;

    private ArrayList<JButton>buttons;
    private static final int MAX = 36;



    public GUI(){

        this.click = 0;
        this.label=new JLabel();
        label.setOpaque(true);
        label.setBackground(Color.GREEN);
        label.setBorder(new BevelBorder(BevelBorder.RAISED));
        label.setBorder(BorderFactory.createEtchedBorder());

        label.setText("Snake and Ladder");

        label.setFont(new Font("Broadway", Font.ITALIC, 50));

        ImageIcon image = new ImageIcon("./main/resources/title.png");
        label.setIcon(image);


        this.mainFrame = new JFrame();
        this.buttonsPanel = new JPanel(new GridLayout(6,6,5,5));
        this.buttons = new ArrayList<>();

        buttonsPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);




    }
    public void initGUI(){

        EventQueue.invokeLater(()->{

            colorButtons();
            eventHandler();

            mainFrame.getRootPane().setBorder(new BevelBorder(BevelBorder.RAISED));
            mainFrame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black,5,true));

        });


        playerOneBut = new JLabel("ABDI");
        playerOneBut.setIcon(new ImageIcon("./main/resources/horse.png"));
        playerTwoBut = new JLabel("PC");
        start = new JButton();
        start.setBackground(Color.GREEN);
        start.setBorder(BorderFactory.createEtchedBorder());

       // start.setBounds(20,20,10,10);
        start.setIcon(new ImageIcon("./main/resources/start.png"));
        mainFrame.add(start,SOUTH);


        label.setForeground(Color.red);


        this.mainFrame.setSize(900,900);
        mainFrame.setResizable(true);
        this.mainFrame.setVisible(true);
        this.mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        setButtonsPanel();
        setPLayerLocation();
        mainFrame.add(label,NORTH);
        mainFrame.add(label,NORTH);
        // minFrame.add(playerOneBut,EAST);
        mainFrame.add(playerTwoBut,WEST);
        playerOneDice = new JButton();

        playerOneDice.setIcon(new ImageIcon("./main/resources/dice4.png"));
        playerOneDice.setFont(new Font("Broadway", Font.BOLD, 12));
        playerOnePanel = new JPanel(new GridLayout(2,1));
        playerTwoDice = new JButton("Roll Dice p2");
        playerTwoDice.setBackground(Color.green);
        playerTwoPanel = new JPanel(new GridLayout(2,1));
        playerTwoPanel.setOpaque(true);
        playerTwoPanel.setBackground(Color.green);

        playerOnePanel.add(playerOneBut);
        playerOnePanel.add(playerOneDice);


        playerOneDice.setBackground(Color.green);
        mainFrame.add(playerOnePanel,EAST);
        playerOnePanel.setBackground(Color.green);
        playerOnePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        playerOnePanel.setBorder(BorderFactory.createLineBorder(Color.RED,2,true));
        playerTwoPanel.setBorder(BorderFactory.createLineBorder(Color.RED,2,true));

        playerOnePanel.setOpaque(true);

        playerTwoPanel.add(playerTwoBut);
        playerTwoPanel.add(playerTwoDice);
        mainFrame.add(playerTwoPanel,WEST);

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
    public void setPLayerLocation(){
        PlayerOne p1 = new PlayerOne();
        PlayerOne p2 = new PlayerOne();
        //JLabel pl1 =new JLabel("Abdi");
        //JLabel pl2 =new JLabel("Mar");
        //buttons.get(35).add(pl1);
        JLabel pl2 = new JLabel("Amr");
        start.addActionListener(begin->{
            //eventHandler();


            buttons.get(trackIndex).add(pl2);
            //buttons.get(buttons.size()-1).add(pl1);
            //p1.setIndex(buttons.size()-1);
            //p2.setIndex(buttons.size()-1);
            //playerOneDice.setEnabled(true);
            //playerTwoDice.setEnabled(true);

            buttons.get(buttons.size()-1).setLayout(new GridLayout(1,1,1,1));
            PlayerOne playerOne =new PlayerOne();

            PlayerTwo playerTwo = new PlayerTwo();
            playerTwo.setYourTurn(false);
            playerOne.setYourTurn(false);
            playerOneDice.addActionListener(a->{
                p1_clickCounter++;
                playerOne.setDiceOne();
                playerTwoDice.setEnabled(false);
                playerOneDice.setText(""+playerOne.getDiceOne());
                playerOne.setIndex(trackIndex+playerOne.getSumOfDice());
                buttons.get(trackIndex+ playerOne.getSumOfDice()).add(pl2);

                if(p1_clickCounter>2){
                    playerOneDice.setEnabled(false);
                    playerTwo.setYourTurn(true);
                    playerTwoDice.setEnabled(true);
                }
            });

        });


        //buttons.get(35).addActionListener(a->{
        //            playerOneDice.addActionListener(d1->{ p1.setDiceOne();
        //               p1.setDiceTwo();
        //             playerOneDice.setText(""+p1.getDiceOne());
        //       });

        //buttons.get(p1.getSumOfDice()).add(l);
        // l.setVisible(true);
        //    });


    }
    public void player1Turn(){
        PlayerOne p1 = new PlayerOne();
        PlayerTwo p2 = new PlayerTwo();

        //    p1.setCountClick(click);
        playerOneDice.addActionListener(pl1->{
            p1.setDiceOne();
            int firstDice = p1.getDiceOne();
            playerOneDice.setText(""+firstDice);
            p1.setDiceTwo();
            int secondDice = p1.getDiceTwo();
            playerOneDice.setText(""+secondDice);
            playerOneDice.setEnabled(false);



            //playerTwoDice.setEnabled(false);// p1.setCountClick();
            //int c = p1.getCountClick();

            //if(c>=2){
            //  playerOneDice.setEnabled(false);
            //playerTwoDice.setEnabled(true);
            //p1.setCountClick();

            //}else {
            //  playerTwoDice.setEnabled(false);
            //playerOneDice.setEnabled(true);

            //}
            //int c2 =p2.getCountClick();
            //System.out.println("p1 click: "+c);
            //System.out.println("p2 click: "+c2);
            // p1.setYourTurn(true);
            // p2.setYourTurn(false);

            // if(p1.getCountClick()>=2)
            // {playerOneDice.setEnabled(false);
            //playerTwoDice.setEnabled(true);
            //          }
        });

    }
    private int setIndexPlayer1(int index){
        return index;

    }

    public void diceButton(){
        this.diceButton = new JButton("Roll Dice");

        jp.add(diceButton);
        mainFrame.add(jp);

    }

private void colorButtons()
{buttons.get(buttons.size()-1).setFont(new Font("Broadway", Font.ITALIC, 20));
buttons.get(0).setFont(new Font("Broadway", Font.ITALIC, 20));

buttons.get(35).setText("FINISH");
buttons.get(0).setText("START");
try {


            for (int i = 1; i < buttons.size(); i +=5) {
                buttons.get(i+1).setBackground(Color.GRAY);
                buttons.get(i + 2).setBackground(Color.CYAN);
                buttons.get(i + 3).setBackground(Color.BLACK);
                buttons.get(i+2/3).setBackground(Color.getHSBColor(.4F,.4F,.4F));

            }
        }catch (IndexOutOfBoundsException iob){
            System.out.println(iob);
        }
}

public void eventHandler(){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object object = e.getSource();
                if(object==start){
                    buttons.get(buttons.size()-1).add(playerOneBut);
                }
            }
        };

}
public void reverse(){
        Collections.reverse(buttons);
}

public void setLadderAndSnake(){
        buttons.get(26).setText("");
        buttons.get(26).setIcon(new ImageIcon("./main/resources/head.png"));
        buttons.get(20).setText("");


        buttons.get(20).setIcon(new ImageIcon("./main/resources/bodyy.png"));
        buttons.get(21).setIcon(new ImageIcon("./main/resources/tail.png"));
        buttons.get(21).setText("");
        buttons.get(17).setText(" ");
        buttons.get(17).setIcon(new ImageIcon("./main/resources/head2.png"));
        buttons.get(11).setText(" ");
        buttons.get(11).setIcon(new ImageIcon("./main/resources/body2.png"));
        buttons.get(10).setText("");
        buttons.get(10).setIcon(new ImageIcon("./main/resources/tail3.png"));
        // buttons.get(6).setIcon(new ImageIcon("src/main/resources/ladder.png" +
        //  ""));

}

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object = e.getSource();
        if(object==start){
            buttons.get(buttons.size()-1).add(playerOneBut);
        }
    }
}
