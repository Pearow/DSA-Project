package src.gui;

import src.Student;
import src.gui.list.List;
import src.gui.list.items.StudentListItem;
import src.structures.tree.StudentTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    public StudentTree tree;
    public Student mainStudent;
    public TeamsPanel teamsPanel;
    private final GridBagConstraints c = new GridBagConstraints();

    public MainFrame(){
        try {
            tree = StudentTree.fromFile("database.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getCause());
            tree = new StudentTree();
        }

        //Set up frame
        setTitle("Teammate Recommendation and Building app");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 360);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        LoginScreen loginScreen = new LoginScreen(this);
        add(loginScreen);

        //Add listeners
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Saving database");
                super.windowClosing(e);
                try {
                    tree.toFile("database.dat");
                    System.out.println("Successfully saved database");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void login(LoginScreen screen, Student student) {
        c.fill = GridBagConstraints.BOTH;


        remove(screen);
        mainStudent = student;
        CurrentStudentPanel currentStudentPanel = new CurrentStudentPanel(student);
        teamsPanel = new TeamsPanel(student);
        List studentList = new List();

        Student[] recommendedStudents = tree.toArray();

        //Insertion sort recommended students
        for (int i = 0; i < recommendedStudents.length; i++) {
            int key = mainStudent.getCompatibility(recommendedStudents[i]);
            Student keyStudent = recommendedStudents[i];
            int j = i - 1;
            while (j >= 0 && key > mainStudent.getCompatibility(recommendedStudents[j])) {
                recommendedStudents[j + 1] = recommendedStudents[j];
                j--;
            }
            recommendedStudents[j + 1] = keyStudent;
        }

        //Add students
        for (Student s : recommendedStudents) {
            if (s == mainStudent) continue;
            studentList.add(new StudentListItem(s, this));
        }

        //Add
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 10;
        c.ipady = 10;
        c.weightx = 1;
        c.weighty = 1;
        add(currentStudentPanel, c);

        c.gridx = 0;
        c.gridy = 1;
        add(teamsPanel, c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 2;
        c.weightx = 3.5;
        c.weighty = 3;
        add(studentList, c);
        repaint();
        revalidate();
    }

}
