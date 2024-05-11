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
        comboPanel.add(teamsCombo, BorderLayout.EAST);
        listPanel.add(teammateList);
        add(titlePanel);
        add(comboPanel);
        add(listPanel);
        add(leaveTeam);
    }

    public static void main(String[] args) {
        Student[] students = new Student[10];
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < 10; i++) {
            students[i] = new Student(random.nextInt(1900000, 2399999), random.nextDouble(4), "John" + i, "Student", new Date(random.nextInt(2000, 2009)), "Computer Science", "Turkish", "123456");
        }
        for (Student student : students) {
            for (int i = 0; i < 12; i++) {
                Student rand = students[random.nextInt(10)];
                if (rand != student) {
                    int ti = random.nextInt(3);
                    if (student.teams.getLenght() < ti || student.teams.getLenght() == 0) {
                        Team team = new Team();
                        student.teams.add(team);
                        rand.teams.add(team);
                        team.add(student);
                    }
//                    ti = Math.clamp(ti, 0, student.teams.getLenght() - 1);

                    student.teams.get(ti, Team.class).add(rand);
                }
            }
        }

        JFrame frame = new JFrame("Teams Panel John 0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        TeamsPanel teamsPanel = new TeamsPanel(students[0]);
        frame.add(teamsPanel);
        frame.setVisible(true);
        JFrame frame2 = new JFrame("Teams Panel John 1");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(400, 200);

        TeamsPanel teamsPanel2 = new TeamsPanel(students[1]);
        frame2.add(teamsPanel2);
        frame2.setVisible(true);
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
//                    System.out.println(selectedTeam.get(i));
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
