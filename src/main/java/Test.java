import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout(new GridLayout(3,3,10,10));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,500);

        JButton but1= new JButton("1");
        JButton but2= new JButton("2");
        JButton but3= new JButton("3");
        JButton but4= new JButton("4");
        JButton but5= new JButton("5");
        JButton but6= new JButton("6");
        JButton but7= new JButton("7");
        JButton but8= new JButton("8");
        JButton but9= new JButton("9");
        f.add(but1);
        f.add(but2);
        f.add(but3);
        f.add(but4);
        f.add(but5);
        f.add(but6);
        f.add(but7);
        f.add(but8);
        f.add(but9);

        JLabel l = new JLabel("eYBAN");
       but9.add(l);
      Point p=  but1.getLocation();
      int x = p.x;
      int y= p.y;

but9.addActionListener(a->{but4.add(l);});
    }
}
