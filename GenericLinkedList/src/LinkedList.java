/**
 * LinkedList
 */
public class LinkedList<T> {
    Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    // 1 -> 2 -> 3 -> null
    public void append(T value) {
        if (this.head == null) {
            this.head = new Node<T>(value);
            return;            
        }

        Node<T> curr = this.head;
        
        while(curr.nextNode != null){
            curr = curr.nextNode;
        }

        curr.nextNode = new Node<T>(value);
    }

    public void prepend(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.nextNode = this.head;
        this.head = newNode;
    }

    // 1 -> 2 -> 3 -> 5 -> null
    // head
    // curr
    public void delete(T value) throws EmptyListException {
        if (this.head == null)
            throw new EmptyListException("List is Empty");
        else if (this.head.value == value) {
            this.head = this.head.nextNode;
        }
        else {
            Node<T> current = head;
            while (current.nextNode.value != value) {
                current = current.nextNode;
            }
            current.nextNode = current.nextNode.nextNode;
        }
        
    }

    // 1 -> 2 -> 3 -> 5 -> null
    public boolean contains(T value) {
        if (isEmpty())
            return false;
        Node<T> curr = this.head;
        while (curr != null) {
            if (curr.value == value)
                return true;
            curr = curr.nextNode;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int indexOf(T value) throws EmptyListException {
        if (this.head == null)
            throw new EmptyListException("List is Empty");
        Node<T> curr = this.head;
        int counter = 0;
        while (curr != null) {
            if (curr.value == value)
                return counter;
            counter++;
            curr = curr.nextNode;
        }
        return -1;
    }

    public int size() throws EmptyListException {
        if (this.head == null)
            return 0;
        Node<T> curr = this.head;
        int counter = 0;
        while (curr != null) {
            counter++;
            curr = curr.nextNode;
        }
        return counter;
    }
    public T getFirst() throws EmptyListException {
        if (this.head == null)
            throw new EmptyListException("List is empty");

        return this.head.value;
    }

    public T get(int index) throws IndexOutOfBoundsException, EmptyListException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<T> current = head;
        int counter = 0;

        for (int i = 0; i < index; i++)
            current = current.nextNode;

        return current.value;
    }

    public T getLast() throws EmptyListException {
        if(this.head == null)
            throw new EmptyListException("List is empty");
        
        // Node<T> curr = this.head;
        // while(curr.nextNode != null){
        //     curr = curr.nextNode;
        // }
        // return curr.value;

        return get(size() - 1);
    }
}