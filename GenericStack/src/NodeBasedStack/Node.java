package NodeBasedStack;

public class Node<T> {
    T value;
    Node<T> nextNode;

    Node(T value){
        this.value = value;
        this.nextNode = null;
     
    }    
}
