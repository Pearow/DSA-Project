package src.structures.tree;

import src.Student;

import java.io.Serializable;

public class Node implements Serializable {
    private double gpa;
    private Student data;
    private Node left;
    private Node right;
//    private Node Root;

    public Node(Student data) {
//        this.data = data;
//        this.gpa = data.getGpa();
//        this.left = null;
//        this.right = null;
    }

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
