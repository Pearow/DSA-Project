package src.structures.linkedList;


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


    //TODO: Will be Fixed Later
    public <T> void remove(T data) {
//      if (head == null) {
//         return;
//      }
//      if (head.getData().equals(data)) {
//         head = head.getNext();
//         lenght--;
//         return;
//      }
//      Node<T> current = head;
//      while (current.getNext() != null) {
//         if (current.getNext().getData().equals(data)) {
//            current.getNext() = current.getNext().getNext();
//            lenght--;
//            return;
//         }
//         current = current.getNext();
//      }
   }
    public int getLenght() {
        return lenght;
    }

    public Node getRoot() {
        return root;
    }
}
