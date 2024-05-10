package src.gui.list;

import src.gui.list.items.TeamListItem;
import src.structures.Team;

import javax.swing.*;
import java.awt.*;

public class TeamsList extends JScrollPane {
    private final JPanel panel = new JPanel();

    public TeamsList(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setViewportView(panel);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public void add(JComponent item){
        panel.add(item);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Teams List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 500);

        TeamsList teamListItem = new TeamsList();
        frame.getContentPane().add(teamListItem, BorderLayout.CENTER);

        for(int i = 1; i < 30; i++)
            teamListItem.add(new TeamListItem(new Team(i)));

        frame.setVisible(true);
    }
}
