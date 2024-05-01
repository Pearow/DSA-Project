package src.structures.tree;

import src.Student;

import java.io.Serializable;

public class Node implements Serializable, Comparable<Node> {
    private Student data;
    private Node left;
    private Node right;
    private int balance;
    private Node parent;

    public Node(Node parent, Student data) {
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public Node(Student data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
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

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getBalance() {
        return balance;
    }

    public void increaseBalance() {
        balance++;
    }

    public void decreaseBalance() {
        balance--;
    }

    @Override
    public int compareTo(Node o) {
        return 0;
    }
}
