package ArrayBasedCircularQueue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircularQueueTest  {

    private Queue<Integer> queue;

    @Before
    public void setUp() {
        queue = new Queue<>(5);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue() throws QueueOverflowException {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
    }

    @Test
    public void testDequeue() throws QueueUnderflowException, QueueOverflowException {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueDequeueWithCapacity() throws QueueOverflowException, QueueUnderflowException {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertEquals(Integer.valueOf(1), queue.dequeue());
        queue.enqueue(6);
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertEquals(Integer.valueOf(4), queue.dequeue());
        assertEquals(Integer.valueOf(5), queue.dequeue());
        assertEquals(Integer.valueOf(6), queue.dequeue());

    }

    @Test(expected=QueueUnderflowException.class)
    public void testDequeueFromEmptyQueue() throws QueueUnderflowException {
        queue.dequeue();
    }

    @Test(expected = QueueOverflowException.class)
    public void testEnqueueToFullQueue() throws QueueOverflowException {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6); // This should throw any exception
    }
}
