package src.gui.DST_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.structures.Team;
import src.structures.linkedList.LinkedList;
import src.structures.linkedList.Node;
import src.structures.tree.Tree;
import src.Student;


public class GUI extends JFrame implements ActionListener {

    JLabel currentStudentName;
    JLabel currentStudentId;
    JButton changeCurrentStudentButton;

    JLabel currentStudentTeams;
    JButton currentStudentSelectTeamsButton;
    JLabel currentStudentViewingTeams;
    JComboBox currentStudentViewingTeamsComboBox;
    JButton currentStudentCreateTeamButton;
    JButton currentStudentLeaveTeamButton;

    JLabel currentStudentRecommended;
    JComboBox currentStudentRecommendedComboBox;

    JLabel currentStudentAllStudents;
    JComboBox currentStudentAllStudentsComboBox;

    JButton exitButton;

    JPanel currentStudentPanel;
    JPanel currentStudentTeamsPanel;
    JPanel currentStudentRecommendedPanel;
    JPanel currentStudentAllStudentsPanel;

    //imports
    String [] recommendedStudents = new String[10];
    String [] allStudents = new String[10];
    String [] teams = new String[10];



    public GUI() {
        super("GUI for Teammate Finder");
        setSize(1240, 740);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 300, 10));
        getContentPane().setBackground(Color.LIGHT_GRAY);

        // Create labels
        currentStudentName = new JLabel("Name: ");
        currentStudentId = new JLabel("ID: ");
        currentStudentName.setFont(new Font("Serif", Font.BOLD, 20));
        currentStudentId.setFont(new Font("Serif", Font.BOLD, 20));
        changeCurrentStudentButton = new JButton("Change Current Student");

        currentStudentTeams = new JLabel("Teams");
        currentStudentTeams.setFont(new Font("Serif", Font.BOLD, 20));
        currentStudentSelectTeamsButton = new JButton("Select Teams");
        currentStudentViewingTeams = new JLabel("Viewing Teams");
        currentStudentViewingTeams.setFont(new Font("Serif", Font.BOLD, 20));
        currentStudentCreateTeamButton = new JButton("Create Team");
        teams[0] = "Team 1";
        teams[1] = "Team 2";
        teams[2] = "Team 3";
        currentStudentViewingTeamsComboBox = new JComboBox(teams);

        currentStudentLeaveTeamButton = new JButton("Leave Team");

        currentStudentRecommended = new JLabel("Recommended");
        currentStudentRecommended.setFont(new Font("Serif", Font.BOLD, 20));
        recommendedStudents[0] = "Recommended 1";
        recommendedStudents[1] = "Recommended 2";
        recommendedStudents[2] = "Recommended 3";
        currentStudentRecommendedComboBox = new JComboBox(recommendedStudents);

        currentStudentAllStudents = new JLabel("All Students");
        currentStudentAllStudents.setFont(new Font("Serif", Font.BOLD, 20));
        allStudents[0] = "Student 1";
        allStudents[1] = "Student 2";
        allStudents[2] = "Student 3";
        currentStudentAllStudentsComboBox = new JComboBox(allStudents);

        exitButton = new JButton("Exit");

        //buttons that open a new window
        currentStudentSelectTeamsButton.addActionListener(this);

        //normal button
        changeCurrentStudentButton.addActionListener(this);
        currentStudentLeaveTeamButton.addActionListener(this);
        currentStudentCreateTeamButton.addActionListener(this);
        exitButton.addActionListener(this);

        currentStudentPanel = new JPanel();
        currentStudentTeamsPanel = new JPanel();
        currentStudentRecommendedPanel = new JPanel();
        currentStudentAllStudentsPanel = new JPanel();

        currentStudentPanel.setLayout(new GridLayout(2, 2, 10, 10));
        currentStudentTeamsPanel.setLayout(new GridLayout(3, 1, 10, 10));
        currentStudentRecommendedPanel.setLayout(new GridLayout(2, 1, 10, 10));
        currentStudentAllStudentsPanel.setLayout(new GridLayout(2, 1, 10, 10));

        currentStudentPanel.setPreferredSize(new Dimension(400, 100));
        currentStudentTeamsPanel.setPreferredSize(new Dimension(400, 500));
        currentStudentRecommendedPanel.setPreferredSize(new Dimension(300, 400));
        currentStudentAllStudentsPanel.setPreferredSize(new Dimension(300, 400));

        currentStudentPanel.add(currentStudentName);
        currentStudentPanel.add(currentStudentId);
        currentStudentPanel.add(changeCurrentStudentButton);

        currentStudentTeamsPanel.add(currentStudentTeams);
        currentStudentTeamsPanel.add(currentStudentSelectTeamsButton);
        currentStudentTeamsPanel.add(currentStudentViewingTeams);
        currentStudentTeamsPanel.add(currentStudentLeaveTeamButton);
        currentStudentTeamsPanel.add(exitButton);

        currentStudentRecommendedPanel.add(currentStudentRecommended);
        currentStudentRecommendedPanel.add(currentStudentRecommendedComboBox);

        currentStudentAllStudentsPanel.add(currentStudentAllStudents);
        currentStudentAllStudentsPanel.add(currentStudentAllStudentsComboBox);

        add(currentStudentPanel);
        add(currentStudentRecommendedPanel);
        add(currentStudentTeamsPanel);
        add(currentStudentAllStudentsPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == changeCurrentStudentButton) {
            System.out.println("Change Current Student");
        }
        if (e.getSource() == currentStudentSelectTeamsButton) {
           JDialog dialog = new JDialog(this, "Select Teams", true);
           dialog.setBounds(0, 0, 400, 400);
           dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

           dialog.setLayout(new GridLayout(2, 1, 10, 10));
           dialog.add(currentStudentViewingTeamsComboBox);
           dialog.add(currentStudentCreateTeamButton);

           dialog.setVisible(true);
        }
        if (e.getSource() == currentStudentLeaveTeamButton) {
            System.out.println("Leave Team");
        }
        if (e.getSource() == currentStudentCreateTeamButton) {
            System.out.println("Create Team");
        }
        if(e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}
