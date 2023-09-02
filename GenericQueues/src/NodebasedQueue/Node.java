package NodebasedQueue;

public class Node<T> {
    protected T value;
    protected Node<T> nextNode;

    Node(T value){
        this.value = value;
        this.nextNode = null;
    }
}
