package BalancedTree;

public class Main {
    public static void main(String[] args) {
        Height height = new Height();

        BalanceTree<Integer> tree = new BalanceTree<>();
        tree.root = new Node<Integer>(1);
        tree.root.leftNode = new Node<Integer>(2);
        tree.root.rigNode = new Node<Integer>(3);
        tree.root.leftNode.leftNode = new Node<Integer>(4);
        tree.root.leftNode.rigNode = new Node<Integer>(5);
        tree.root.leftNode.rigNode.rigNode = new Node<Integer>(6);

        if (tree.checkBalance(tree.root, height))
            System.out.println("Tree is balanced!");
        else
            System.out.println("Tree is not balanced!");
    }
}
