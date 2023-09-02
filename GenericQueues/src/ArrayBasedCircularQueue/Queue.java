package ArrayBasedCircularQueue;

public class Queue<T> {
    protected T[] arr;
    protected int front;
    protected int rear;
    protected int capacity;
    protected int currentSize;

    @SuppressWarnings("unchecked")
    Queue(int capacity) {
        this.arr = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.currentSize = 0;
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(T data) throws QueueOverflowException {
        if (isFull())
            throw new QueueOverflowException("Queue is full!");
        else {

            rear = (rear + 1) % capacity;
            
            if (front == -1)
                front = 0;

            arr[rear] = data;
            currentSize++;
        }
    }


    public T dequeue() throws QueueUnderflowException {
        if (isEmpty())
            throw new QueueUnderflowException("Queue is empty!");
        T element = arr[front];
        if (front == rear) {
            rear = -1;
            front = -1;
        } 
        else if (front == capacity-1){
            front = 0;
        }
        else {
            front++;
        }
        currentSize--;
        return element;
    }

    public T peek() throws QueueUnderflowException {
        if (isEmpty())
            throw new QueueUnderflowException("Queue is empty!");
        return arr[front];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == capacity;
    }

    public int size() {
        return currentSize;
    }
}
