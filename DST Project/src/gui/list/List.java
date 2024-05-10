package src.gui.list;
import src.gui.list.items.TeammateListItem;

import javax.swing.*;
import java.awt.*;

public class List extends JScrollPane {
    private final JPanel panel = new JPanel();
    public List(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setViewportView(panel);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    }

    public void add(JComponent item){
        panel.add(item);
    }
    public void remove(JComponent item){
        panel.remove(item);
    }
    public void clear(){
        panel.removeAll();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 500);
        List studentList = new List();
        frame.getContentPane().add(studentList, BorderLayout.CENTER);
        for(int i = 1; i < 100; i++)
            studentList.add(new TeammateListItem(new src.Student(123456, 3.5,"John" + i, "Doe", new java.util.Date(2000, 1, 1), "Computer Science", "Turkish", "123456")));

        frame.setVisible(true);
    }
}
