package src.structures.tree;

import src.Student;

import java.io.Serializable;

public class Tree implements Serializable {
    private Node root;

    public void add(Student data) {
        Node newNode = new Node(data);
        add(root, null, newNode);
    }

    private Node add(Node pointer, Node parent, Node newNode){
        if(pointer == null) {
            newNode.setParent(parent);
            return newNode;
        }
        if(pointer.compareTo(newNode) >= 0){
            pointer.increaseBalance();
            pointer.setRight(add(pointer.getRight(), pointer, newNode));
        }
        else if(pointer.compareTo(newNode) < 0){
            pointer.decreaseBalance();
            pointer.setLeft(add(pointer.getLeft(), pointer, newNode));
        }
        return pointer;
    }

    public boolean remove(int id) throws Exception{
        return remove(findNode(id));
    }

    private boolean remove(Node node) throws Exception{
        if (node == null)
            return false;
        if (node.getLeft() == null && node.getRight() == null) {
            if (node != root) {
                if (node.getParent().getLeft() == node)
                    node.getParent().setLeft(null);
                else
                    node.getParent().setRight(null);
            } else
                root = null;
            return true;
        } else if (node.getLeft() != null && node.getRight() != null) {
                Node min = node;
                while (min.getLeft() != null)
                    min = min.getLeft();
                node.setData(min.getData());
                if (!remove(min))
                    throw new Exception("Child node not found");
                return true;

        } else {
            Node child = node.getLeft() != null ? node.getLeft() : node.getRight();
            if (node != root) {
                if (node.getParent().getLeft() == node)
                    node.getParent().setLeft(child);
                else
                    node.getParent().setRight(child);
                return true;
            }else {
                root = child;
                return true;
            }
        }
    }

    public Student find(int id){
        Node node = findNode(id);
        if(node != null)
            return node.getData();
        return null;
    }

    private Node findNode(int id){
        Node pointer = root;
        while (pointer != null){
            if(pointer.getData().getId() == id)
                return pointer;
            else if(pointer.getData().getId() > id)
                pointer = pointer.getLeft();
            else
                pointer = pointer.getRight();
        }
        return null;
    }

    //TODO: Implement balanceTree
    public boolean balanceTree(){
        return false;
    }

    public void toFile(){

    }

    public static Tree fromFile(){
        return null;
    }
}
