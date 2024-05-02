package src.structures.tree;

import src.Student;

import java.io.Serializable;
import java.util.Objects;

public class Node implements Serializable, Comparable<Node> {
    private Student data;
    private Node left;
    private Node right;
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

    public int getHeight() {
        if(right == null && left == null)
            return 0;
        else if (right != null && left != null)
            return Math.max(right.getHeight(), left.getHeight()) + 1;
        else return Objects.requireNonNullElseGet(right, () -> left).getHeight() + 1; // Automatically recommended by IntelliJ
    }

    public void rightRotate() {
        Node newRoot = left;
        left = newRoot.getRight();
        newRoot.setRight(this);
        newRoot.setParent(parent);
        parent = newRoot;
    }

    public void leftRotate() {
        Node newRoot = right;
        right = newRoot.getLeft();
        newRoot.setLeft(this);
        newRoot.setParent(parent);
        parent = newRoot;
    }
    @Override
    public int compareTo(Node o) {
        return 0;
    }
}
