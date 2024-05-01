package src;

import src.structures.linkedList.LinkedList;

public class Student implements Comparable<Student> {
    private LinkedList data;
    private int id;

    public double getGpa(){
        return 0.0;
    }

    public void setGpa(double gpa) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int compareGpa (){
        return 0;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
