package src.gui.list.items;

import src.structures.Team;
import src.Student;
import src.gui.AddToTeamPopup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TeamListItem extends JPanel implements ActionListener {
    public final Team team;
    public Student selectedStudent;

     public TeamListItem(Team team, Student selectedStudent){

         this.selectedStudent = selectedStudent;
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
            team.add(selectedStudent);
            System.out.println("Added " + selectedStudent.getName() + " to team " + team.getId());
            //Debug
            for(int i = 0; i < team.getLenght(); i++){
                System.out.println(team.get(i));
            }
       }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Team list item");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        Student oldStudent = new Student(123456, 3.5,"John", "Doe", new Date(2000, 1, 1), "Computer Warrior", "Turkish", "123456");
        Student newStudent = new Student(2, 1.0, "Jane", "Doe", new Date(2000, 1, 1), "Social Justice", "American", "password");
        Team team = new Team();
        team.add(oldStudent);
        oldStudent.teams.add(team);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.getContentPane().add(new TeamListItem(team, newStudent));

        frame.setVisible(true);
    }
}
