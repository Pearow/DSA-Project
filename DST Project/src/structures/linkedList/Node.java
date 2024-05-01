package src.structures.linkedList;

import src.Student;
public class Node<T> {
    private T data;

    private double gpa;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}


