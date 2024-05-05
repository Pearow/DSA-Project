package src.structures.linkedList;

import src.Student;

import java.io.Serializable;

public class Node<T> implements Serializable {
    private T data;

    private double gpa;
    private Node<T> next;
    private Node<T> prev;

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

    public Node getPrev() {
        return next;
    }

    public void setPrev(Node<T> next) {
        this.next = next;
    }
}


