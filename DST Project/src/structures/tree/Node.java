package src.structures.tree;

import src.Student;

import java.io.Serializable;
import java.util.Objects;

public class Node <T extends Integer> implements Serializable, Comparable<Node> {
    private T data;
    private Node left;
    private Node right;
    private Node parent;
    private int height;

    public Node(Node parent, T data) {
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public Node(T data) {
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
        // this.id = data.getId();
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
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public StringBuilder inOrder(int no) {
        StringBuilder sb = new StringBuilder();
        if (left != null) {
            sb.append(left.inOrder(no + 1));
        }
        sb.append(data.toString()).append("\n");
        if (right != null) {
            sb.append(right.inOrder(no + 1));
        }
        return sb;
    }

    @Override
    public int compareTo(Node o) {
        return data.compareTo(o.getData());//TODO
    }
}
