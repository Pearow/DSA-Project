package src.gui.list.items;

import src.Student;
import src.gui.AddToTeamPopup;
import src.gui.MainFrame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StudentListItem extends JPanel {
    public final Student student;

    public StudentListItem(Student student, MainFrame mainFrame) {
        this.student = student;
        //Set up components
        JLabel studentName = new JLabel(student.getName() + " " + student.getSurname());
        JButton addToTeam = new JButton("+");

        //Set layout
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 17));
        setBorder(new EmptyBorder(0, 5, 0, 5));

        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 65), 1));

        //Set
        addToTeam.addActionListener(e -> {
            new AddToTeamPopup(mainFrame, student);
        });


        add(studentName, BorderLayout.WEST);
        add(addToTeam, BorderLayout.EAST);
    }
}