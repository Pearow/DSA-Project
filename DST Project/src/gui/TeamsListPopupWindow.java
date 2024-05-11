package src.gui;

import src.Student;
import src.gui.list.List;
import src.structures.Team;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

import src.gui.list.TeamsList;
import src.gui.list.items.TeamListItem;

public class TeamsListPopupWindow extends JDialog {

    public TeamsListPopupWindow(JFrame parent, List teamsList){
        super(parent, "Team", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(parent);

        //Set layout
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 17));

//        teamsList.add(new TeamListItem(new Team()));
        add(teamsList, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Teams list popup window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 500);
        List teamsList = new List();
        Team team = new Team();
        Student student = new Student(123, 3.5, "John", "Doe", new Date(), "Computer Science", "Turkish", "123456");
        team.add(student);
//        teamsList.add(new TeamListItem(team, student));
        TeamsListPopupWindow teamsPopupWindow = new TeamsListPopupWindow(frame, teamsList);

    }

}
