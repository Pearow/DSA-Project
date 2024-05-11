package src.gui;

import src.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JPanel implements ActionListener {

    private JTextField idField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private MainFrame parentFrame;
    private Student st;

    public LoginScreen(MainFrame parentFrame) {
        this.parentFrame = parentFrame;
        // Create labels
        idField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        idField.setMaximumSize(new Dimension(500, 20));
        passwordField.setMaximumSize(new Dimension(500, 20));

        // Set layout
        setLayout(new GridLayout(3,2));
        setPreferredSize(new Dimension(200, 200));

        // Add fields
        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Password:"));
        add(passwordField);

        // Add button to change current team
        add(loginButton);

        loginButton.addActionListener(this);
    }

    private boolean login() {
        try {
            int id = Integer.parseInt(idField.getText());
            String password = new String(passwordField.getPassword());
            st = parentFrame.tree.find(id);
            if (st != null && id == st.getId() && password.equals(st.getPassword())) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter integer for ID field", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            if (login()) {
                System.out.println("Login successful");
                parentFrame.login(this, st);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid ID or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
            // Change current team
        }
    }
}
