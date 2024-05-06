package src.gui;
import javax.swing.*;
import java.awt.*;

public class guiDeneme_2 {
    public static void main(String[] args) {
        //JPanel is a component that can act as a container for other components

        JLabel label = new JLabel();
        label.setText("Hi");
        //label.setVerticalAlignment(JLabel.BOTTOM);
        //label.setHorizontalAlignment(JLabel.RIGHT);
        label.setBounds(100, 100, 75, 75);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0, 0, 250, 250);
        redPanel.setLayout(null);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(250, 0, 250, 250);
        bluePanel.setLayout(null);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0, 250, 500, 250);
        greenPanel.setLayout(null);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1240, 740);

        frame.add(redPanel);
        greenPanel.add(label);
        frame.add(bluePanel);
        frame.add(greenPanel);
        frame.setVisible(true);

    }
}
