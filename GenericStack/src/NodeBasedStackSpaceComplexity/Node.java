package NodeBasedStackSpaceComplexity;
public class Node<T> {
    T value;
    T minValue;
    Node<T> nextNode;

    Node(T value, T minValue){
        this.value = value;
        this.nextNode = null;
        this.minValue = minValue;
    }    
}
