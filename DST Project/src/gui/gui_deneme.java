package src.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class gui_deneme extends JFrame {

    public gui_deneme() {
        // Set frame properties
        setTitle("Simple Swing Example");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Add a label
       JLabel hello_world = new JLabel("Hello World", JLabel.CENTER);
       add(hello_world);
        // Make the frame visible
        setVisible(true);
    }
    public static void main(String[] args) {
        // Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new gui_deneme();
            }
        });
    }
}
