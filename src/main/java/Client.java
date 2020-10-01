import javax.swing.*;
import java.awt.*;

public class Client {
    public static void main(String[] args) {


        EventQueue.invokeLater(()->{

       UIDefaults uiDefaults = UIManager.getDefaults();
            uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.GREEN));
            //UIManager.put("InternalFrame.titleFont", new Font("Dialog", Font.ITALIC, ));

            //JFrame.setDefaultLookAndFeelDecorated(true);
            GUI gui = new GUI();
            SwingUtilities.updateComponentTreeUI(gui.mainFrame);
           gui.mainFrame.invalidate();
           gui.mainFrame.validate();
            gui.mainFrame.repaint();

            gui.initGUI();
            PlayerOne one = new PlayerOne();
            PlayerTwo two = new PlayerTwo();
            one.setDiceOne();

            gui.reverse();
            gui.setPLayerLocation();
            gui.setLadderAndSnake();

        });




    }
}
