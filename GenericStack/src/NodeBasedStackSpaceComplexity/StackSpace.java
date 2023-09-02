package NodeBasedStackSpaceComplexity;

public class StackSpace<T extends Comparable<T>> {
    protected Node<T> top;
    public StackSpace() {
        this.top = null;
    }

    public void push(T data) throws StackUnderflowException {
        Node<T> node;
        if(isEmpty() || (peek().compareTo(data) > 0)){
            node = new Node<>(data, data);
        }
        else{
           node = new Node<>(data, top.minValue);
        }
        node.nextNode = top;
        this.top = node;
    }

    public T getMin(){
        return top.minValue;
    }

    
    // 1 -> 2 -> null
    public T pop() throws StackUnderflowException {
        if(isEmpty())
            throw new StackUnderflowException("Stack is Empty!");
        T curr = top.value;
        top = top.nextNode;
        return curr;
    }

    public T peek() throws StackUnderflowException{
        if(isEmpty())
            throw new StackUnderflowException("Stack is Empty!");
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }
    
    public int size() {
        Node<T> curr = top;
        int count = 0;
        while(curr != null){
            count++;
            curr = curr.nextNode;
        }
        return count;
    }

    public void clear() {
        top = null;
    }
}
