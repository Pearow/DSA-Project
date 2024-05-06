package src.gui.guiDeneme_16;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MyFrame extends JFrame implements ActionListener{

    JMenuBar menuBar;
    // JMenu fileMenu, editMenu, helpMenu;
    // JMenuItem loadItem, saveItem, exitItem;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.setMnemonic(KeyEvent.VK_F);  // Alt + f for file
        editMenu.setMnemonic(KeyEvent.VK_E);  // Alt + e for edit
        helpMenu.setMnemonic(KeyEvent.VK_H);  // Alt + h for help

        loadItem.setMnemonic(KeyEvent.VK_L);  // l for load
        saveItem.setMnemonic(KeyEvent.VK_S);  // s for save
        exitItem.setMnemonic(KeyEvent.VK_E);  // e for exit

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //if(e.getSource() == loadItem) {
        //    System.out.println("Load Clicked");
        //} else if(e.getSource() == saveItem) {
        //    System.out.println("Save Clicked");
        //} else if(e.getSource() == exitItem) {
        //    System.out.println("Exit Clicked");
        //} better to use actionCommand

        if(e.getActionCommand().equals("Load")) {
            System.out.println("Load Clicked");
        } else if (e.getActionCommand().equals("Save")) {
            System.out.println("Save Clicked");
        } else if (e.getActionCommand().equals("Exit")) {
            System.out.println("Exit Clicked");
            System.exit(0);
        }
    }
}
