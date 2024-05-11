package src.gui.list.items;

import src.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TeammateListItem extends JPanel {
    public final Student student;

    public TeammateListItem(Student student) {
        this.student = student;
        //Set up components
        JLabel studentName = new JLabel(student.getName() + " " + student.getSurname());
        JLabel studentID = new JLabel(Integer.toString(student.getId()));

        //Set layout
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 25));
        setBorder(new EmptyBorder(0, 5, 0, 5));

        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 65), 1));
        studentName.setFont(new Font("Arial", Font.BOLD, 15));
        studentID.setFont(new Font("Arial", Font.PLAIN, 15));


        add(studentName, BorderLayout.WEST);
        add(studentID, BorderLayout.EAST);
    }


}
