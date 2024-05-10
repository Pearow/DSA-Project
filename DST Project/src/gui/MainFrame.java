package src.gui;

import javax.swing.*;

import src.Student;
import src.gui.list.List;
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
    StudentTree tree;
    Student mainStudent;
    public MainFrame() {
        try {
        tree = StudentTree.fromFile("database.dat");
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getCause());
            tree = new StudentTree();
        }

        //Set up frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        LoginScreen loginScreen = new LoginScreen(this);
        add(loginScreen);
        pack();
    }

    public void login(LoginScreen screen, Student student){
        remove(screen);
        mainStudent = student;
        CurrentStudentPanel currentStudentPanel = new CurrentStudentPanel(student);
        add(currentStudentPanel);
        pack();
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
