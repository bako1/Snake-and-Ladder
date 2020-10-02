import java.awt.*;

public class Client {
    public static void main(String[] args) {


        EventQueue.invokeLater(()->{

            GUI gui = new GUI();

            gui.initGUI();
            gui.reverse();
            gui.setLadderAndSnake();
            gui.setStartButton();
            gui.setPlayerOnePanel();
            gui.setPlayerTwoPanel();
            gui.setUpActionListener();

        });




    }
}
