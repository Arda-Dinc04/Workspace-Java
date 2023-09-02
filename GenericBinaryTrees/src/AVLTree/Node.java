package AVLTree;

public class Node<T> {
    T data;
    Node<T> leftNode;
    Node<T> rightNode;
    int height;

    Node(T data){
        this.data = data;
        height = 1;
    }
}
