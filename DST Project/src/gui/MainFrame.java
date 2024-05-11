package src.gui;

import javax.swing.*;

import src.Student;
import src.gui.list.List;
import src.gui.list.items.StudentListItem;
import src.structures.Team;
import src.structures.linkedList.LinkedList;
import src.structures.linkedList.Node;
import src.structures.tree.Tree;
//import src.structures.tree.Node;
import src.gui.list.TeamsList;
import src.gui.LoginScreen;
import src.structures.tree.StudentTree;

import java.io.IOException;

public class MainFrame extends JFrame {
    public StudentTree tree;
    public Student mainStudent;
    public TeamsPanel teamsPanel;
    public MainFrame() {
        try {
        tree = StudentTree.fromFile("database.dat");
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getCause());
            tree = new StudentTree();
        }

        //Set up frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1240, 740);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        LoginScreen loginScreen = new LoginScreen(this);
        add(loginScreen);
        pack();
    }

    public void login(LoginScreen screen, Student student){
        remove(screen);
        mainStudent = student;
        CurrentStudentPanel currentStudentPanel = new CurrentStudentPanel(student);
        teamsPanel = new TeamsPanel(student);
        List studentList = new List();

        Student[] recommendedStudents = tree.toArray();

        //Insertion sort recommended students
        for(int i = 0; i < recommendedStudents.length; i++){
            int key = mainStudent.getCompatibility(recommendedStudents[i]);
            Student keyStudent = recommendedStudents[i];
            int j = i - 1;
            while(j >= 0 && key > mainStudent.getCompatibility(recommendedStudents[j])){
                recommendedStudents[j + 1] = recommendedStudents[j];
                j--;
            }
            recommendedStudents[j + 1] = keyStudent;
        }

        //Add students
        for(Student s: recommendedStudents){
            if(s == mainStudent) continue;
            studentList.add(new StudentListItem(s, this));
        }

        //Add
        add(currentStudentPanel);
        add(teamsPanel);
        add(studentList);
        pack();
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
