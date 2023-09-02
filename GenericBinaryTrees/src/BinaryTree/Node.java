package BinaryTree;

public class Node<T> {
    protected T data;
    protected Node<T> left;
    protected Node<T> right;

    Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
}
