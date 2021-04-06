//toan le
//occc spring 2021
//advance java
//JPanel homework

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TLE_BackgroundColorChangerJPanel extends JFrame implements ActionListener{

    private static final int HEIGHT = 600;
    private static final int WIDTH = 600;

    //JLabel label;
    int counter = 0;
    private int index;
    private JButton btn;
    private Color[] colors = new Color[]{
            Color.red, Color.green, Color.blue, Color.CYAN, Color.LIGHT_GRAY, Color.MAGENTA, Color.YELLOW
    };
    JLabel label = new JLabel("Counter: 0");
    JFrame frame = new JFrame("TLE");
    public TLE_BackgroundColorChangerJPanel()
    {
        initializeColor();


    }
    public void initializeColor(){
        JPanel panel = new JPanel();
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);
        index = 0;
        btn = new JButton("Click to change button color:");
        btn.addActionListener(this);
        setLayout(new BorderLayout());
        btn.setBounds(75,75,400,400);
        label.setBounds(250,10,100,100);
        panel.add(label);
        panel.add(btn);

    }

    public static void main(String[] args)
    {

        TLE_BackgroundColorChangerJPanel main = new TLE_BackgroundColorChangerJPanel();
    }

    public void actionPerformed(ActionEvent e)
    {
        counter++;
        if(index < (colors.length-1)){
            index++;
        }
        else {
            index = 0;
        }
        btn.setBackground(colors[index]);
        label.setText("Counter: " + counter);
    }
}