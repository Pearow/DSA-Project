package src.gui.list.items;

import src.structures.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamsList extends JDialog implements ActionListener {
    public final Team team;

    public TeamsList(JFrame parent, Team team){
        super(parent, "Team", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        this.team = team;
        //Set up components
        JLabel teamID = new JLabel(String.valueOf(this.team.getId()));
        JButton addToSelectedTeam = new JButton("+");

        //Set layout
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 17));


        add(teamID, BorderLayout.WEST);
        add(addToSelectedTeam, BorderLayout.EAST);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("+")) {
            System.out.println("Add to team");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Teams List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        new TeamsList(frame, new Team(1));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        Team deneme = new Team(1);
        System.out.println(deneme.getId());
    }

}
