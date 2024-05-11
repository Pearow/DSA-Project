package src.structures.tree;

import src.structures.hasID;

import java.io.Serializable;
import java.util.ArrayList;

public class Node<Student extends hasID> implements Serializable, Comparable<Node<Student>> {
    private Student data;
    private Node<Student> left;
    private Node<Student> right;
    private Node<Student> parent;
    private int height;
    private int id;

    public Node(Node<Student> parent, Student data) {
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
        this.id = data.getId();
    }

    public Node(Student data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.id = data.getId();
    }

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
        this.id = data.getId();
    }

    public Node<Student> getLeft() {
        return left;
    }

    public void setLeft(Node<Student> left) {
        this.left = left;
    }

    public Node<Student> getRight() {
        return right;
    }

    public void setRight(Node<Student> right) {
        this.right = right;
    }

    public Node<Student> getParent() {
        return parent;
    }

    public void setParent(Node<Student> parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        if (left != null) {
            sb.append(left.inOrder());
        }
        sb.append(data.toString()).append("\n");
        if (right != null) {
            sb.append(right.inOrder());
        }
        return sb.toString();
    }

    public ArrayList<Student> inOrder(ArrayList<Student> list) {
        if (left != null) {
            left.inOrder(list);
        }
        list.add(data);
        if (right != null) {
            right.inOrder(list);
        }
        return list;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(getId(), o.getId());
    }

    public String toString() {
        return inOrder();
    }
}
