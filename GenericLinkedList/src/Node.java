/**
 * Node
 */
public class Node<T> {
    T value;
    Node<T> nextNode;

    public Node(T value){
        this.value = value;
        this.nextNode = null;
    }
}