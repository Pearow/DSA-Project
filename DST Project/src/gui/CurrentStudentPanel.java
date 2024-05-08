package src.gui;

import src.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentStudentPanel extends JPanel implements ActionListener {

    private JLabel currentStudentName;
    private JLabel currentStudentId;
    private JPanel currentStudentInfoPanel;
    private JButton changeCurrentStudentButton;

    public CurrentStudentPanel(Student student) {
        // Create labels
        currentStudentName = new JLabel("Name: " + student.getName() + " " + student.getSurname());
        currentStudentId = new JLabel("ID: " + student.getId());
        currentStudentName.setFont(new Font("Serif", Font.BOLD, 20));
        currentStudentId.setFont(new Font("Serif", Font.BOLD, 20));
        changeCurrentStudentButton = new JButton("Change Current Student");

        // Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 200));


        // Create panel for student info
        currentStudentInfoPanel = new JPanel();
        currentStudentInfoPanel.setLayout(new BoxLayout(currentStudentInfoPanel, BoxLayout.Y_AXIS));
        currentStudentInfoPanel.add(currentStudentName);
        currentStudentInfoPanel.add(currentStudentId);
        add(currentStudentInfoPanel);

        // Add button to change current student
        add(changeCurrentStudentButton);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Current Student Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.add(new CurrentStudentPanel(new Student(123456, 3.5,"John", "Doe", new java.util.Date(2000, 1, 1), "Computer Science", "Turkish", "123456")));
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeCurrentStudentButton) {
            // Change current student
        }
    }
}
