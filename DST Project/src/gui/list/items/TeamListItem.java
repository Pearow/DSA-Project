package src.gui.list.items;

import src.gui.list.TeamsList;
import src.structures.Team;
import src.Student;
import src.gui.list.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamListItem extends JPanel implements ActionListener {
    public final Team team;

     public TeamListItem(Team team){
         this.team = team;
         JLabel teamID = new JLabel(String.valueOf(this.team.getId()));
         JButton addToSelectedTeam = new JButton("+");

         addToSelectedTeam.addActionListener(this);

         setLayout(new BorderLayout());
         setPreferredSize(new Dimension(100, 17));
         setBorder(new EmptyBorder(0, 5, 0, 5));

         setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 65), 1));


         add(teamID, BorderLayout.WEST);
         add(addToSelectedTeam, BorderLayout.EAST);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("+")) {
//            team.add(List.selectedStudent());
//            System.out.println("Added " + List.selectedStudent + "to team " + team.getId());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Team list item");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        new TeamListItem(new Team(1));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.getContentPane().add(new TeamListItem(new Team(1)));

        Team deneme = new Team(1);

        System.out.println(deneme.getId());

        frame.setVisible(true);
    }
}
