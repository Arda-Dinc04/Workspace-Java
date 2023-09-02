package NodeBasedPQ;

public class NodePQ<T extends Comparable<T>> {

    private Node<T> front;
    private Node<T> rear;
    private int currentSize;

    NodePQ() {
        this.currentSize = 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        }
        else {
            if (data.compareTo(front.value) > 0) {
                newNode.nextNode = front;
                front = newNode;
            } else {
                Node<T> curr = front;
                while (curr.nextNode != null && data.compareTo(curr.nextNode.value) <= 0) {
                    curr = curr.nextNode;
                }

                newNode.nextNode = curr.nextNode;
                curr.nextNode = newNode;

                if (newNode.nextNode == null) {
                    rear = newNode;
                }
            }
        }
        currentSize++;
    }

    public T dequeue() throws PQUnderflowException {
        if (isEmpty())
            throw new PQUnderflowException("PQ is empty!!");

        T out = front.value;
        front = front.nextNode;
        currentSize--;

        if (isEmpty()) {
            front = null;
            rear = null;
        }
        return out;

    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

}
