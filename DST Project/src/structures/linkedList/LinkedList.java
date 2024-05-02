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

   //İstersen
   //TODO: Get items from nodes according to their index
    public <T> T get(int index, Class<T> Tclass){
        if (index < 0 || head == null) {
            throw new NoSuchElementException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                throw new NoSuchElementException();
            }
            current = current.next;
        }
        return Tclass.cast(current.data);
    }
    

    //TODO: Find the node with specified index and change its data to variable "data". Return true if completed succesfully else rtrn fls

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
