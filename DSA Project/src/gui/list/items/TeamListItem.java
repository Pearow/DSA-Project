package src.gui.list.items;

import src.Student;
import src.gui.TeamsListPopupWindow;
import src.structures.Team;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TeamListItem extends JPanel implements ActionListener {
    public final Team team;
    private final TeamsListPopupWindow teamsListPopupWindow;
    public Student selectedStudent;

    public TeamListItem(Team team, Student selectedStudent, TeamsListPopupWindow teamsListPopupWindow) {

        this.selectedStudent = selectedStudent;
        this.team = team;
        this.teamsListPopupWindow = teamsListPopupWindow;
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

            teamsListPopupWindow.dispose();
        }
    }
}
