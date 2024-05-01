package src.structures.linkedList;

import src.Student;
public class Node {

    private double gpa;
    private Student data;
    private Node next;

    public Node(Student data) {
        this.data = data;
        this.gpa = data.getGpa;
        this.next = null;
    }

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public src.structures.linkedList.Node getNext() {
        return next;
    }

    public void setNext(src.structures.linkedList.Node next) {
        this.next = next;
    }
}


