package src.gui.list;

import src.gui.list.items.TeamListItem;
import src.structures.Team;

import javax.swing.*;
import java.awt.*;

public class TeamsList extends List {

    public TeamsList(){
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Teams List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 500);

        TeamsList teamListItem = new TeamsList();
        frame.getContentPane().add(teamListItem, BorderLayout.CENTER);

        for(int i = 1; i < 30; i++)
//            teamListItem.add(new TeamListItem(new Team(), ));

        frame.setVisible(true);
    }
}
