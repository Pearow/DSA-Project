package src.gui.list.items;

import src.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;

public class StudentListItem extends JPanel{
    private static boolean cool = true;
    public final Student student;

    public StudentListItem(Student student){
        this.student = student;
        //Set up components
        JLabel studentName = new JLabel(student.getName() + " " + student.getSurname());
        JButton addToTeam = new JButton("+");

        //Set layout
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 17));
        setBorder(new EmptyBorder(0, 5, 0, 5));

        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 65), 1));


        add(studentName, BorderLayout.WEST);
        add(addToTeam, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student TeamsList Item");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 41 + new StudentListItem(new Student()).getPreferredSize().height);
        frame.add(new StudentListItem(new Student(123456, 3.5,"John", "Doe", new Date(2000, 1, 1), "Computer Science", "Turkish", "123456")));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setVisible(true);
    }
}
