package src.gui.list.items;

import src.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;

public class TeammateListItem extends JPanel {
    public final Student student;

    public TeammateListItem(Student student){
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student List Item");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 41 + new TeammateListItem(new Student()).getPreferredSize().height);
        frame.add(new TeammateListItem(new Student(123456, 3.5,"John", "Doe", new Date(2000, 1, 1), "Computer Science", "Turkish", "123456")));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setVisible(true);
    }


}
