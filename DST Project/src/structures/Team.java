package src.structures;

import src.structures.linkedList.LinkedList;
import src.Student;
import src.structures.linkedList.Node;

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
        this.add(student);
    }

    public boolean exists(Student student){
        if(getLenght() == 0)
            return false;
        boolean exists = false;
        Node<Student> pointer = getRoot();
        do{
            if(pointer.getData() == student){
                exists = true;
                break;
            }
        }while((pointer = pointer.getNext()) != null);
        return exists;
    }

    public Student get(int index){
        return super.get(index, Student.class);
    }

    public int getId() {
        return this.teamId;
    }

    public int getStudentCount() {
        return this.getLenght();
    }

    public void add(Student student) {
        if(!exists(student))
            super.add(student);
    }

}