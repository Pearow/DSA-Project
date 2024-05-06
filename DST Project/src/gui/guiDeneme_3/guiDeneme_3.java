package src.gui.guiDeneme_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiDeneme_3 extends JFrame implements ActionListener {
    JButton button;
    JLabel label;
    guiDeneme_3() {

        //ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("point.jpg"));
        //ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("point.png"));

        label = new JLabel();
        //label.setIcon(icon2);
        label.setText("Hi");
        label.setBounds(150, 250, 150, 150);
        label.setVisible(false);
        this.add(label);

        button = new JButton();
        button.setBounds(100, 100, 250, 100);
        button.addActionListener(this);
        //button.addActionListener(e -> System.out.println("Lambda Button clicked"); use without implementing ActionListener
        button.setText("Click me");
        button.setFocusable(false);
        //button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new java.awt.Font("Comic Sans", Font.BOLD, 25));
        button.setIconTextGap(-15);
        button.setForeground(Color.cyan);
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createEtchedBorder());
        //button.setEnabled(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            //System.out.println("Button clicked");
            //button.setEnabled(false);
            label.setVisible(true);
        }
    }
}
