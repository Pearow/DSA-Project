package src.gui;

import src.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrentStudentPanel extends JPanel {

    private JLabel currentStudentName;
    private JLabel currentStudentId;
    private JPanel currentStudentInfoPanel;

    public CurrentStudentPanel(Student student) {
        // Create labels
        currentStudentName = new JLabel("Name: " + student.getName() + " " + student.getSurname());
        currentStudentId = new JLabel("ID: " + student.getId());
        currentStudentName.setFont(new Font("Serif", Font.BOLD, 20));
        currentStudentId.setFont(new Font("Serif", Font.BOLD, 20));

        // Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 200));


        // Create panel for team info
        currentStudentInfoPanel = new JPanel();
        currentStudentInfoPanel.setLayout(new BoxLayout(currentStudentInfoPanel, BoxLayout.Y_AXIS));
        currentStudentInfoPanel.add(currentStudentName);
        currentStudentInfoPanel.add(currentStudentId);
        add(currentStudentInfoPanel);
    }
}
