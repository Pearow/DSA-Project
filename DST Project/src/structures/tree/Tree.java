package src.structures.tree;

import src.Student;

import java.io.Serializable;
import java.util.Random;

//TODO: Change recursive to loop
public class Tree <T extends Integer> implements Serializable {
    private Node<T> root;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if(root != null)
            add(root, null, newNode);
        else
            root = newNode;
    }

    private Node<T> add(Node<T> pointer, Node<T> parent, Node<T> newNode){
        if(pointer == null) {
            newNode.setParent(parent);
            return newNode;
        }
        if(pointer.compareTo(newNode) < 0){
            pointer.setRight(add(pointer.getRight(), pointer, newNode));
        }
        else if(pointer.compareTo(newNode) >= 0) {
            pointer.setLeft(add(pointer.getLeft(), pointer, newNode));
        }

        int balance =  (pointer.getLeft() != null ? pointer.getLeft().getHeight(): 0) - (pointer.getRight() != null ? pointer.getRight().getHeight(): 0);
        if(balance > 1 && pointer.getLeft().compareTo(newNode) > 0)
            return leftRotate(pointer);
        else if(balance < -1 && pointer.getRight().compareTo(newNode) < 0)
            return rightRotate(pointer);
        else if(balance > 1 && pointer.getLeft().compareTo(newNode) < 0){
            pointer.setLeft(leftRotate(pointer.getLeft()));
            return rightRotate(pointer);
        }
        else if(balance < -1 && pointer.getRight().compareTo(newNode) > 0){
            pointer.setRight(rightRotate(pointer.getRight()));
            return leftRotate(pointer);
        }
        return pointer;
    }

    public int getHeight(Node<T> node){
        if (node == null)
            return 0;
        return node.getHeight();
    }

    Node<T> rightRotate(Node<T> y) {
        Node<T> x = y.getLeft();
        Node<T> T2 = x.getRight();

        // Perform rotation
        x.setRight(y);
        y.setLeft(T2);

        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node<T> leftRotate(Node<T> x) {
        Node<T> y = x.getRight();
        Node<T> T2 = y.getLeft();

        // Perform rotation
        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);

        // Return new root
        return y;
    }

    int getBalance(Node<T> N) {
        if (N == null)
            return 0;

        return getHeight(N.getLeft()) - getHeight(N.getRight());
    }

    public boolean remove(int id){
        Node<T> node = findNode(id);
        if(node == null)
            return false;
        delete(root, node);
        return true;
    }

    //TODO: Fix root cant be deleted
    private Node<T> delete(Node<T> pointer, Node<T> node){
        if(node == null)
            return null;
        if(node.compareTo(pointer) < 0){
            pointer.setLeft(delete(pointer.getLeft(), node));
        }
        else if(node.compareTo(pointer) > 0){
            pointer.setRight(delete(pointer.getRight(), node));
        }
        else {
            if(pointer.getLeft() == null || pointer.getRight() == null){
                Node<T> temp = null;
                if(pointer.getLeft() == null)
                    temp = pointer.getRight();
                else
                    temp = pointer.getLeft();
                if(temp == null){
                    if(pointer.getParent().getLeft() == pointer)
                        pointer.getParent().setLeft(null);
                    else
                        pointer.getParent().setRight(null);
                    pointer = null;
                }
                else
                    pointer = temp;
            }
            else {
                Node<T> temp = minValueNode(pointer.getRight());
                pointer.setData(temp.getData());
                pointer.setRight(delete(pointer.getRight(), temp));
            }
        }

        if(pointer == null)
            return pointer;

        pointer.setHeight(Math.max(getHeight(pointer.getLeft()), getHeight(pointer.getRight())) + 1);
        int balance = getBalance(pointer);

        if(balance > 1 && getBalance(pointer.getLeft()) >= 0)
            return rightRotate(pointer);
        if(balance < -1 && getBalance(pointer.getRight()) <= 0)
            return leftRotate(pointer);
        if(balance > 1 && getBalance(pointer.getLeft()) < 0) {
            pointer.setLeft(leftRotate(pointer.getLeft()));
            return rightRotate(pointer);
        }
        if(balance < -1 && getBalance(pointer.getRight()) > 0) {
            pointer.setRight(rightRotate(pointer.getRight()));
            return leftRotate(pointer);
        }
        return pointer;
    }

    private Node<T> minValueNode(Node<T> node){
        Node<T> current = node;
        while (current.getLeft() != null)
            current = current.getLeft();
        return current;
    }

    public Student find(int id){
//        Node node = findNode(id);
//        if(node != null)
//            return node.getData();
        return null;
    }

//    private Node<T> findNode(int id){
//        Node pointer = root;
//        while (pointer != null){
//            if(pointer.getData().getId() == id)
//                return pointer;
//            else if(pointer.getData().getId() > id)
//                pointer = pointer.getLeft();
//            else
//                pointer = pointer.getRight();
//        }
//        return null;
//    }

    private Node<T> findNode(int data){
        Node pointer = root;
        while (pointer != null){
            if(pointer.getData() == data)
                return pointer;
            else if(pointer.getData() > data)
                pointer = pointer.getLeft();
            else
                pointer = pointer.getRight();
        }
        return null;
    }

    public String inOrder(){
        return root.inOrder(1).toString();
    }

    public void toFile(){

    }

    public static Tree fromFile(){
        return null;
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);

        System.out.println(tree.inOrder());

        if(tree.remove(10))
            System.out.println("Removed");
        else
            System.out.println("Not found");

        System.out.println(tree.inOrder());
    }
}
