package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insertNode(8);
        tree.insertNode(3);
        tree.insertNode(10);
        tree.insertNode(1);
        tree.insertNode(6);
        tree.insertNode(14);
        tree.insertNode(4);
        tree.insertNode(7);

        tree.inOrderTraversal();
        tree.deleteNode(3);
        System.out.println();
        tree.inOrderTraversal();
    }
}
