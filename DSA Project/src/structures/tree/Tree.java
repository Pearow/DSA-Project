package src.structures.tree;

import src.structures.hasID;

import java.io.*;
import java.util.ArrayList;

public class Tree<Student extends hasID> implements Serializable {
    private Node<Student> root;

    public static Tree fromFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream("data/" + fileName));
        return (Tree) stream.readObject();
    }

    public void add(Student data) {
        Node<Student> newNode = new Node<>(data);
        if (root != null)
            add(root, null, newNode);
        else
            root = newNode;
    }

    // Thanks to GeeksForGeeks for the rotation methods
    private Node<Student> add(Node<Student> pointer, Node<Student> parent, Node<Student> newNode) {
        if (pointer == null) {
            newNode.setParent(parent);
            return newNode;
        }
        if (pointer.compareTo(newNode) < 0) {
            pointer.setRight(add(pointer.getRight(), pointer, newNode));
        } else if (pointer.compareTo(newNode) >= 0) {
            pointer.setLeft(add(pointer.getLeft(), pointer, newNode));
        }

        int balance = (pointer.getLeft() != null ? pointer.getLeft().getHeight() : 0) - (pointer.getRight() != null ? pointer.getRight().getHeight() : 0);
        if (balance > 1 && pointer.getLeft().compareTo(newNode) > 0)
            return leftRotate(pointer);
        else if (balance < -1 && pointer.getRight().compareTo(newNode) < 0)
            return rightRotate(pointer);
        else if (balance > 1 && pointer.getLeft().compareTo(newNode) < 0) {
            pointer.setLeft(leftRotate(pointer.getLeft()));
            return rightRotate(pointer);
        } else if (balance < -1 && pointer.getRight().compareTo(newNode) > 0) {
            pointer.setRight(rightRotate(pointer.getRight()));
            return leftRotate(pointer);
        }
        return pointer;
    }

    public int getHeight(Node<Student> node) {
        if (node == null)
            return 0;
        return node.getHeight();
    }

    Node<Student> rightRotate(Node<Student> y) {
        Node<Student> x = y.getLeft();
        Node<Student> T2 = x.getRight();

        // Perform rotation
        x.setRight(y);
        y.setParent(x);
        y.setLeft(T2);

        if (T2 != null)
            T2.setParent(y);

        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node<Student> leftRotate(Node<Student> x) {
        Node<Student> y = x.getRight();
        Node<Student> T2 = y.getLeft();

        // Perform rotation
        y.setLeft(x);
        x.setParent(y);
        x.setRight(T2);

        if (T2 != null)
            T2.setParent(x);

        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);

        // Return new root
        return y;
    }

    int getBalance(Node<Student> N) {
        if (N == null)
            return 0;

        return getHeight(N.getLeft()) - getHeight(N.getRight());
    }

    public boolean remove(int id) {
        Node<Student> node = findNode(id);
        if (node == null)
            return false;
        root = delete(root, node);
        return true;
    }

    private Node<Student> delete(Node<Student> pointer, Node<Student> node) {
        if (node == null)
            return null;
        if (node.compareTo(pointer) < 0) {
            Node<Student> left = delete(pointer.getLeft(), node);
            pointer.setLeft(left);

        } else if (node.compareTo(pointer) > 0) {
            pointer.setRight(delete(pointer.getRight(), node));
        } else {
            if (pointer.getLeft() == null || pointer.getRight() == null) {
                Node<Student> temp = null;
                if (pointer.getLeft() == null)
                    temp = pointer.getRight();
                else
                    temp = pointer.getLeft();
                if (temp == null) {
                    if (pointer.getParent().getLeft() == pointer)
                        pointer.getParent().setLeft(null);
                    else
                        pointer.getParent().setRight(null);
                    pointer = null;
                } else
                    pointer = temp;
            } else {
                Node<Student> temp = minValueNode(pointer.getRight());
                pointer.setData(temp.getData());
                pointer.setRight(delete(pointer.getRight(), temp));
            }
        }

        if (pointer == null)
            return pointer;

        pointer.setHeight(Math.max(getHeight(pointer.getLeft()), getHeight(pointer.getRight())) + 1);
        int balance = getBalance(pointer);

        if (balance > 1 && getBalance(pointer.getLeft()) >= 0)
            return rightRotate(pointer);
        if (balance < -1 && getBalance(pointer.getRight()) <= 0)
            return leftRotate(pointer);
        if (balance > 1 && getBalance(pointer.getLeft()) < 0) {
            pointer.setLeft(leftRotate(pointer.getLeft()));
            return rightRotate(pointer);
        }
        if (balance < -1 && getBalance(pointer.getRight()) > 0) {
            pointer.setRight(rightRotate(pointer.getRight()));
            return leftRotate(pointer);
        }
        return pointer;
    }

    private Node<Student> minValueNode(Node<Student> node) {
        Node<Student> current = node;
        while (current.getLeft() != null)
            current = current.getLeft();
        return current;
    }

    Node<Student> findNode(int data) {
        Node<Student> pointer = root;
        while (pointer != null) {
            if (pointer.getData().getId() == data)
                return pointer;
            else if (pointer.getData().getId() > data)
                pointer = pointer.getLeft();
            else
                pointer = pointer.getRight();
        }
        return null;
    }

    public String inOrder() {
        return root.inOrder();
    }

    public ArrayList<Student> toArrayList() {
        ArrayList<Student> students = new ArrayList<>();
        return root.inOrder(students);
    }

    public void toFile(String fileName) throws IOException {
        File file = new File("data");
        file.mkdir();
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("data/" + fileName));
        stream.writeObject(this);
    }
}
