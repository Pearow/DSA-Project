package src.structures.linkedList;


import java.util.ArrayList;
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

   private Node getNode(int index){
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


   //İstersen
   //TODO: Get items from nodes according to their index
    public <T> T get(int index, Class<T> Tclass) throws NoSuchElementException {
        return Tclass.cast(getNode(index).getData());
    }

    public <T> boolean edit(int index, T data){
        getNode(index).setData(data);
        return true;
    }


    //TODO: Find the node with specified index and change its data to variable "data". Return true if completed succesfully else rtrn fls

    //TODO: Will be Fixed Later
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

    public String[] getArray(){
        ArrayList<String> list = new ArrayList<>();
        Node pointer = root;
        while (pointer != null){
            list.add(pointer.getData().toString());
            pointer = pointer.getNext();
        }
        String[] alist = new String[list.size()];
        list.toArray(alist);
        return alist;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove(1);
        for(String a: linkedList.getArray())
            System.out.println(a);
    }

}

