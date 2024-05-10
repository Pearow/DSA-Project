package src.gui;

import javax.swing.*;

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
