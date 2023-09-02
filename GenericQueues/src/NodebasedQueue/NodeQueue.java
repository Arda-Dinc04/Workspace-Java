package NodebasedQueue;

public class NodeQueue<T extends Comparable<T>> {

    protected Node<T> front;
    protected Node<T> rear;
    protected int currentSize;

    NodeQueue() {
        this.currentSize = 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }
        else{
            rear.nextNode = newNode; 
            rear = newNode;
        }
        currentSize++;
    }

    public T dequeue() throws QUnderflowException {
        if (isEmpty())
            throw new QUnderflowException("PQ is empty!!");
        
        T out = front.value;
        front = front.nextNode;
        currentSize--;

        if(isEmpty()){
            front = null;
            rear = null;
        }
        return out;

    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

}
