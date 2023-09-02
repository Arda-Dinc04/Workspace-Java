package ArrayBasedStack;
public class Stack<T> {
    private int top;
    private T[] arr;
    private int capacity;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.currentSize = 0;
        arr = (T[]) new Object[capacity];
    }

    public void push(T data) throws StackOverflowException {
        if (isFull())
            throw new StackOverflowException("Stack is Full!");
        currentSize++;
        arr[++top] = data;
    }

    public T pop() throws StackUnderflowException {
        if(isEmpty())
            throw new StackUnderflowException("Stack is Empty!");
        currentSize--;
        return arr[top--];
    }

    public T peek() throws StackUnderflowException{
        if(isEmpty())
            throw new StackUnderflowException("Stack is Empty!");
        
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == capacity-1;
    }
    
    int size() {
        return currentSize;
    }

}
