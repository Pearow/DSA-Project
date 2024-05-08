package src.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.Student;

public class LoginScreen extends JPanel implements ActionListener {

    private JTextField idField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JFrame parentFrame;

    public LoginScreen(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        // Create labels
        idField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        // Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 200));

        // Add fields
        add(idField);
        add(passwordField);

        // Add button to change current student
        add(loginButton);

        loginButton.addActionListener(this);
    }

    private boolean login() {
       try {
           Student student = new src.Student(123456, 3.5,"John", "Doe", new java.util.Date(2000, 1, 1), "Computer Science", "Turkish", "123456");
           int id = Integer.parseInt(idField.getText());
           String password = new String(passwordField.getPassword());
           if (id == student.getId() && password.equals(student.getPassword())) {
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
        if (e.getSource() == loginButton){
            if(login()){
                parentFrame.dispose();
                System.out.println("Login successful");
            }
            else{
                JOptionPane.showMessageDialog(this, "Invalid ID or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
            // Change current student
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.add(new LoginScreen(frame));
        frame.setVisible(true);
    }
}
