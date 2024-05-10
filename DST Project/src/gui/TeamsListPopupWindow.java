package src.gui;

import src.structures.Team;

import javax.swing.*;
import java.awt.*;

import src.gui.list.TeamsList;
import src.gui.list.items.TeamListItem;

public class TeamsListPopupWindow extends JDialog {

    public TeamsListPopupWindow(JFrame parent, TeamsList teamsList){
        super(parent, "Team", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(parent);

        //Set layout
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 17));

//        teamsList.add(new TeamListItem(new Team()));
        add(teamsList, BorderLayout.CENTER);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Teams list popup window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 500);
        TeamsListPopupWindow teamsPopupWindow = new TeamsListPopupWindow(frame, new TeamsList());
    }

}
