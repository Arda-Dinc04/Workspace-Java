package ArrayBasedPQ;

public class ArrayPQ<T extends Comparable<T>> {

    private T[] arr;
    private int front;
    private int size;

    @SuppressWarnings("unchecked")
    ArrayPQ(int capacity) {
        this.arr = (T[]) new Comparable[capacity];
        this.front = 0;
        this.size = 0;
    }

    public void enqueue(T data) throws PQOverflowException {
        if (isFull()) {
            throw new PQOverflowException("PQ is full!");
        }
        
        int i;
        for (i = size - 1; i >= 0 && arr[i].compareTo(data) < 0; i--) {
            arr[i + 1] = arr[i];
        }

        // 
        arr[i + 1] = data;
        size++;
    }


    public T dequeue() throws PQUnderflowException {
        if (isEmpty())
            throw new PQUnderflowException("PQ is empty!!");

        T out = arr[front];
        front++;
        size--;
        return out;

    }

    public boolean isFull() {
        return size == arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
