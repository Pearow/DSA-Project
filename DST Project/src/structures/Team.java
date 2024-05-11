package src.structures;

import src.Student;
import src.structures.linkedList.LinkedList;
import src.structures.linkedList.Node;

import java.io.*;

public class Team extends LinkedList implements Serializable {
    private static int teamsCount = 0;
    public final int teamId;

    public Team() {
        teamId = teamsCount++;
    }

    public Team(int teamId) {
        this.teamId = teamId;
    }

    public Team(Student student) {
        this();
        this.add(student);
    }

    public Student get(int index) {
        return super.get(index, Student.class);
    }

    public boolean remove(Student student) {
        Node<Student> pointer = root;
        int i = 0;
        while (pointer != null) {
            if (pointer.getData() == student) {
                super.remove(i);
                return true;
            }
            i++;
            pointer = pointer.getNext();
        }
        return false;
    }

    public boolean exists(Student student) {
        if (getLenght() == 0)
            return false;
        boolean exists = false;
        Node<Student> pointer = getRoot();
        do {
            if (pointer.getData() == student) {
                exists = true;
                break;
            }
        } while ((pointer = pointer.getNext()) != null);
        return exists;
    }

    public int getId() {
        return this.teamId;
    }

    public int getStudentCount() {
        return this.getLenght();
    }

    public void add(Student student) {
        if (exists(student))
            return;
        super.add(student);
        if (student.findTeam(teamId) == null)
            student.teams.add(this);
        else System.out.println("Student is already in the team");
    }

    public static void saveTeamCount() {
        try{
            FileOutputStream fileOut = new FileOutputStream("data\\teamCount.dat");
            fileOut.write(teamsCount);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadTeamCount() {
        try {
            File file = new File("data\\teamCount.dat");
            if (file.exists())
                teamsCount = new FileInputStream(file).read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}