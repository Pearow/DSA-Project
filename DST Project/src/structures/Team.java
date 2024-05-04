package src.structures;

import src.structures.linkedList.LinkedList;
import src.Student;

import java.io.Serializable;

public class Team extends LinkedList implements Serializable {
    public final int teamId;
    private static int teamsCount = 0;

    public Team() {
        teamId = teamsCount++;
    }

    public Team(int teamId) {
        this.teamId = teamId;
    }

    public Team(Student student) {
        this();
        this.addStudent(student);
    }

    public int getStudentCount() {
        return this.getLenght();
    }

    public void addStudent(Student student) {
        this.add(student);
    }

}
