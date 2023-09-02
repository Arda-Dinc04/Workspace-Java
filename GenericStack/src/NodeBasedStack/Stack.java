package NodeBasedStack;
public class Stack<T> {
    protected Node<T> top;
    public Stack() {
        this.top = null;
    }

    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.nextNode = top;
        this.top = node;
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
