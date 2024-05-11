package src.structures.linkedList;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedList implements Serializable {
    protected Node root;
    protected int lenght;

    public LinkedList() {
        this.root = null;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove(1);
        for (String a : linkedList.getArray())
            System.out.println(a);
    }

    public <T> void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        lenght++;
    }

    private Node getNode(int index) {
        if (index < 0 || root == null) {
            throw new NoSuchElementException();
        }
        Node current = root;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null) {
                throw new NoSuchElementException();
            }
            current = current.getNext();
        }
        return current;
    }

    public <T> T get(int index, Class<T> Tclass) throws NoSuchElementException {
        return Tclass.cast(getNode(index).getData());
    }

    public <T> int find(T data) {
        Node current = root;
        int index = 0;
        while (current != null) {
            if (current.getData() == data) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public <T> boolean edit(int index, T data) {
        getNode(index).setData(data);
        return true;
    }

    public boolean remove(int index) {
        if (root == null) {
            return false;
        }
        if (index == 0) {
            root = root.getNext();
            lenght--;
            return true;
        }
        Node prev = getNode(index - 1);
        Node current = prev.getNext();

        prev.setNext(current.getNext());
        lenght--;
        return true;
    }

    public int getLenght() {
        return lenght;
    }

    public Node getRoot() {
        return root;
    }

    public String[] getArray() {
        ArrayList<String> list = new ArrayList<>();
        Node pointer = root;
        while (pointer != null) {
            list.add(pointer.getData().toString());
            pointer = pointer.getNext();
        }
        String[] alist = new String[list.size()];
        list.toArray(alist);
        return alist;
    }

}

