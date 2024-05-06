package src.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class guiDeneme_9 {

    public static void main(String[] args) {
        //JOptionPane.showMessageDialog(null, "Hello World", "Title", JOptionPane.PLAIN_MESSAGE);

        //int answer = JOptionPane.showConfirmDialog(null, "Do you like Java?", "Title", JOptionPane.YES_NO_CANCEL_OPTION);
        //String name = JOptionPane.showInputDialog("Enter your name: ");
        //System.out.println("Hello: " + name);

        String [] responses = {"Yes", "No", "Maybe"};
        Icon icon = new ImageIcon(ClassLoader.getSystemResource("point.png"));

        JOptionPane.showOptionDialog(null, "You are awesome!", "Secret Message", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, icon, responses, 0);

    }
}
