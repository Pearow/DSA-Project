package src.gui;

import src.Student;
import src.gui.list.List;
import src.gui.list.items.TeammateListItem;
import src.structures.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TeamsPanel extends JPanel implements ActionListener {
    private final JComboBox<String> teamsCombo;
    private final List teammateList;
    private final JButton leaveTeam;
    private final Student student;

    public TeamsPanel(Student student) {
        //Set up components
        JLabel title = new JLabel("Teams");
        teamsCombo = new JComboBox<>();
        teammateList = new List();
        leaveTeam = new JButton("Leave Team");
        this.student = student;

        JPanel titlePanel = new JPanel();
        JPanel comboPanel = new JPanel();
        JPanel listPanel = new JPanel();

        //Add listeners
        teamsCombo.addActionListener(this);
        leaveTeam.addActionListener(this);

        //Set layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        titlePanel.setLayout(new BorderLayout());
        comboPanel.setLayout(new BorderLayout());
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        //Set properties
        title.setFont(new Font("Arial", Font.BOLD, 15));
        title.setHorizontalAlignment(SwingConstants.LEFT);
        teamsCombo.setPreferredSize(new Dimension(175, 20));

        //Add teams
        loadTeams();

        //Add components
        titlePanel.add(title, BorderLayout.NORTH);
        comboPanel.add(new JLabel("Viewing"), BorderLayout.WEST);
        comboPanel.setPreferredSize(new Dimension(300, 20));
        comboPanel.add(teamsCombo, BorderLayout.EAST);
        listPanel.add(teammateList);
        add(titlePanel);
        add(comboPanel);
        add(listPanel);
        add(leaveTeam);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == teamsCombo && teamsCombo.getSelectedIndex() != -1) {
            teammateList.clear();

            if (student.teams.getLenght() > 0) {
                Team selectedTeam = student.teams.get(teamsCombo.getSelectedIndex(), Team.class);

                //Add teammates
                for (int i = 0; i < selectedTeam.getLenght(); i++) {
                    teammateList.add(new TeammateListItem(selectedTeam.get(i)));
                }

                teammateList.revalidate();
            }else {
                teammateList.clear();
                teammateList.revalidate();
            }

        } else if (e.getSource() == leaveTeam) {
            if (teamsCombo.getSelectedIndex() == -1) {
                return;
            }
            Team selectedTeam = student.teams.get(teamsCombo.getSelectedIndex(), Team.class);

            //Remove student from team
            selectedTeam.remove(student);
            student.teams.remove(student.teams.find(selectedTeam));

            teamsCombo.removeAllItems();

            //Add teams
            loadTeams();

            if(student.teams.getLenght() == 0){
                teammateList.clear();
                teammateList.revalidate();
            }
        }
    }

    public void loadTeams() {
        teamsCombo.removeAllItems();
        for (int i = 0; i < student.teams.getLenght(); i++) {
            teamsCombo.addItem("Team " + student.teams.get(i, Team.class).teamId);
        }
    }

}
