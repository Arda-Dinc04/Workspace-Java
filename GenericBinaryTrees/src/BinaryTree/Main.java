package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.root = new Node<>(20);
        binaryTree.root.left = new Node<>(10);
        binaryTree.root.left.left = new Node<>(5);
        binaryTree.root.left.right = new Node<>(15);
        binaryTree.root.left.left.left = new Node<>(3);
        binaryTree.root.left.left.left.right = new Node<>(4);
        binaryTree.root.right = new Node<>(40);
        binaryTree.root.right.left = new Node<>(30);
        binaryTree.root.right.left.left = new Node<>(25);
        binaryTree.root.right.left.right = new Node<>(35);
        binaryTree.root.right.left.right.left = new Node<>(34);

        System.out.println("Inorder Traversal: ");
        binaryTree.inOrderTraversal(binaryTree.root);
        System.out.println();

        System.out.println("Preorder Traversal: ");
        binaryTree.preOrderTraversal(binaryTree.root);
        System.out.println();

        System.out.println("Postorder Traversal: ");
        binaryTree.postOrderTraversal(binaryTree.root);

    }
}






    