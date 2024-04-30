package structures.tree;

public class bst_deneme {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inorder();

        tree.deleteKey(20);

        System.out.println("Inorder traversal of the modified tree after deletion of 20");
        tree.inorder();
    }
}