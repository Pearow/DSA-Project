package src.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import src.Student;
import src.gui.list.TeamsList;

public class AddToTeamPopup extends JDialog implements ActionListener {

    private JButton addToTeamButton;
    private JLabel infoLabelId;
    private JLabel infoLabelGpa;
    private JLabel infoLabelName;
    private JLabel infoLabelSurname;
    private JLabel infoLabelDob;
    private JLabel infoLabelDepartment;
    private JLabel infoLabelNationality;
    public final Student selectedStudent;
    private JDialog TeamsListPopupWindow;

    public AddToTeamPopup(JFrame parent, Student selectedStudent) {
        super(parent, "Add to Team", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 220);
        setLocationRelativeTo(parent);
        setLayout(null);

        this.selectedStudent = selectedStudent;

        addToTeamButton= new JButton("Add to Team");
        addToTeamButton.setBounds(10, 10, 100, 20);
        add(addToTeamButton);

        infoLabelId = new JLabel("ID: " + selectedStudent.getId());
        infoLabelId.setBounds(10, 40, 200, 20);

        infoLabelGpa = new JLabel("GPA: " + selectedStudent.getGpa());
        infoLabelGpa.setBounds(10, 60, 200, 20);

        infoLabelName = new JLabel("Name: " + selectedStudent.getName());
        infoLabelName.setBounds(10, 80, 200, 20);

        infoLabelSurname = new JLabel("Surname: " + selectedStudent.getSurname());
        infoLabelSurname.setBounds(10, 100, 200, 20);

        infoLabelDob = new JLabel("Date of Birth: " + selectedStudent.getDob());
        infoLabelDob.setBounds(10, 120, 200, 20);

        infoLabelDepartment = new JLabel("Department: " + selectedStudent.getDepartment());
        infoLabelDepartment.setBounds(10, 140, 200, 20);

        infoLabelNationality = new JLabel("Nationality: " + selectedStudent.getNationality());
        infoLabelNationality.setBounds(10, 160, 200, 20);

        add(infoLabelId);
        add(infoLabelGpa);
        add(infoLabelName);
        add(infoLabelSurname);
        add(infoLabelDob);
        add(infoLabelDepartment);
        add(infoLabelNationality);


        addToTeamButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToTeamButton) {
            TeamsListPopupWindow = new TeamsListPopupWindow(new JFrame(), new TeamsList());
            System.out.println("Adding " + selectedStudent.getName() + " to team ");
            dispose();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Add to Team Popup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        new AddToTeamPopup(frame, new Student(123456, 3.5,"John", "Doe", new Date(2000, 1, 1), "Computer Science", "Turkish", "123456"));
        frame.setLayout(null);
    }
}
