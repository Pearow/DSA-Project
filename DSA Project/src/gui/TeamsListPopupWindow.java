package src.gui;

import src.Student;
import src.gui.list.List;
import src.structures.Team;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class TeamsListPopupWindow extends JDialog {

    public TeamsListPopupWindow(JFrame parent, List teamsList) {
        super(parent, "Team", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(parent);

        //Set layout
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(100, 17));

        add(teamsList, BorderLayout.CENTER);
    }

}
