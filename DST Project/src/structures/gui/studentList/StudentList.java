package src.structures.gui.studentList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StudentList extends JScrollPane {
    private final JPanel Panel = new JPanel();
    public StudentList(){
        Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));
        setViewportView(Panel);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        setPreferredSize(new Dimension(200, 200));
//        setMinimumSize(new Dimension(200, 200));
//        setMaximumSize(new Dimension(200, 200));

        //Swing fix for glitching
        new Thread(new SwingFix(this)).start();
    }

    public void add(StudentListItem item){
        Panel.add(item);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        StudentList studentList = new StudentList();
        frame.getContentPane().add(studentList, BorderLayout.CENTER);
        for(int i = 1; i < 101; i++)
            studentList.add(new StudentListItem(new src.Student(123456, 3.5,"John" + i, "Doe", new java.util.Date(2000, 1, 1), "Computer Science", "Turkish", "123456")));

        SwingFix fix = new SwingFix(studentList);
        Thread thread = new Thread(fix);
        thread.start();

        frame.setVisible(true);
    }
}

class SwingFix implements Runnable{
    StudentList list;

    public SwingFix(StudentList list){
        this.list = list;
    }

    public void run(){
        try {
            while (list != null) {
                Thread.sleep(1000);
                list.repaint();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
