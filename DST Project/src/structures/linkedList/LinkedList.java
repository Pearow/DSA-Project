package src.structures.linkedList;


import java.util.NoSuchElementException;

public class LinkedList {
   private Node root;
   private int lenght;

   public LinkedList() {
      this.root = null;
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

   //İstersen
   //TODO: Get items from nodes according to their index
    public <T> T get(int index, Class<T> Tclass) throws NoSuchElementException {
        if (index < 0 || root == null) {
            throw new NoSuchElementException();
        }
        Node current = root;
        for (int i = 0; i <= index; i++) {
            if (current.getNext() == null) {
                throw new NoSuchElementException();
            }
            current = current.getNext();
        }
        return Tclass.cast(current.getData());
    }

    public <T> boolean edit(int index, T data){
        if (index < 0 || root == null) {
            throw new NoSuchElementException();
        }
        Node current = root;
        for (int i = 0; i <= index; i++) {
            if (current.getNext() == null) {
                throw new NoSuchElementException();
            }
            current = current.getNext();
        }

        current.setData(data);
        return true;
    }


    //TODO: Find the node with specified index and change its data to variable "data". Return true if completed succesfully else rtrn fls

    //TODO: Will be Fixed Later
    public <T> void remove(T data) {
     if (root == null) {
         return;
     }
     if (root.getData().equals(data)) {
        root = root.getNext();
        lenght--;
         return;
     }
     Node current = root;
     Node prev = null;
      while (current.getNext() != null) {
        if (current.getData().equals(data)) {
            prev.setNext(current.getNext());
            lenght--;
          return;
        }
        prev = current;
        current = current.getNext();
     }
   }
    public int getLenght() {
        return lenght;
    }

    public Node getRoot() {
        return root;
    }
}
