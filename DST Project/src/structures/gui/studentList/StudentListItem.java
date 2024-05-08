package src.structures.gui.studentList;

import src.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;

public class StudentListItem extends JPanel{
    private static boolean cool = true;
    private JLabel studentName;
    private JButton addToTeam;
    private Student student;

    public StudentListItem(Student student){
        this.student = student;
        //Set up components
        studentName = new JLabel(student.getName() + " " + student.getSurname());
        addToTeam = new JButton("+");


        //Debug
        if(cool){
            setBackground(new Color(0, 0, 0, 15));
            cool = false;
        }else cool = true;

        //Set layout
        setLayout(new BorderLayout());
//        setMinimumSize(new Dimension(100, 17));
        setPreferredSize(new Dimension(100, 17));
//        setMaximumSize(new Dimension(1000, 17));
        setBorder(new EmptyBorder(0, 5, 0, 5));


        add(studentName, BorderLayout.WEST);
        add(addToTeam, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student List Item");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.add(new StudentListItem(new Student(123456, 3.5,"John", "Doe", new Date(2000, 1, 1), "Computer Science", "Turkish", "123456")));
        frame.add(new StudentListItem(new Student(1234562, 3.5,"John3", "Doe", new Date(2000, 1, 1), "Computer Science", "Turkish", "123456")));
        frame.add(new StudentListItem(new Student(1234562, 3.5,"John3", "Doe", new Date(2000, 1, 1), "Computer Science", "Turkish", "123456")));
        frame.add(new StudentListItem(new Student(1234562, 3.5,"John3", "Doe", new Date(2000, 1, 1), "Computer Science", "Turkish", "123456")));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setVisible(true);
    }
}
