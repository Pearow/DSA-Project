package src.structures.linkedList;

public class LinkedList <T>{
   private Node<T> root;
   private int lenght;
   private Node<T> head;

   public LinkedList() {
      this.head = null;
   }
   public void add(T data) {
      Node<T> newNode = new Node<>(data);
      if (head == null) {
         head = newNode;
      } else {
         Node<T> current = head;
         while (current.next != null) {
            current = current.next;
         }
         current.next = newNode;
      }
      lenght++;
   }



    public void remove(T data) {
      if (head == null) {
         return;
      }
      if (head.data.equals(data)) {
         head = head.next;
         lenght--;
         return;
      }
      Node<T> current = head;
      while (current.next != null) {
         if (current.next.data.equals(data)) {
            current.next = current.next.next;
            lenght--;
            return;
         }
         current = current.next;
      }
   }
    public int getLenght() {
        return lenght;
    }

    public Node<T> getRoot() {
        return root;
    }
}
