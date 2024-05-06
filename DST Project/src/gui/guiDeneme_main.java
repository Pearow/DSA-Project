package src.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class guiDeneme_main extends JFrame {

    public guiDeneme_main() {
        // Set frame properties
        this.setTitle("Simple Swing Example");
        this.setSize(1240, 740);
        this.setLocationRelativeTo(null); // centers the frame to the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 4);

        // Add a label
       JLabel hello_world = new JLabel("Hello World", JLabel.CENTER);
       hello_world.setForeground(Color.BLACK);
       hello_world.setFont(new Font("Serif", Font.BOLD, 30));
       hello_world.setBorder(border);
       //hello_world.setVerticalAlignment(JLabel.TOP);
       //hello_world.setHorizontalAlignment(JLabel.LEFT);
       hello_world.setBounds(0, 0, 250, 250);
       add(hello_world);
//       JLabel text = new JLabel("This is a test");
//       add(text);
       this.getContentPane().setBackground(new Color(210,210,210));
       this.setLayout(null);
        //this.pack(); //sets the size of the frame according to the components
        // Make the frame visible
       this.setVisible(true);
    }
    public static void main(String[] args) {
        guiDeneme_main gui = new guiDeneme_main();
    }
}
