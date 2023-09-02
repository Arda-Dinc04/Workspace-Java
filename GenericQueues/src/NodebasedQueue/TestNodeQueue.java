package NodebasedQueue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestNodeQueue {
    private NodeQueue<Integer> nodePQ;

    @Before
    public void setUp() {
        nodePQ = new NodeQueue<>();
    }

    @Test
    public void testEnqueueToEmptyQueue() {
        nodePQ.enqueue(5);
        assertEquals(Integer.valueOf(5), nodePQ.front.value);
        assertEquals(Integer.valueOf(5), nodePQ.rear.value);
        assertFalse(nodePQ.isEmpty());
    }

    @Test
    public void testEnqueueMultipleElements() {
        nodePQ.enqueue(1);
        assertEquals(Integer.valueOf(1), nodePQ.front.value);
        assertEquals(Integer.valueOf(1), nodePQ.rear.value);
        nodePQ.enqueue(2);
        assertEquals(Integer.valueOf(1), nodePQ.front.value);
        assertEquals(Integer.valueOf(2), nodePQ.rear.value);
        nodePQ.enqueue(3);
        assertEquals(Integer.valueOf(1), nodePQ.front.value);
        assertEquals(Integer.valueOf(3), nodePQ.rear.value);
        nodePQ.enqueue(5);
        assertEquals(Integer.valueOf(1), nodePQ.front.value);
        assertEquals(Integer.valueOf(5), nodePQ.rear.value);
        assertFalse(nodePQ.isEmpty());
    }

    @Test(expected = QUnderflowException.class)
    public void testDequeueFromEmptyQueue() throws QUnderflowException {
        nodePQ.dequeue();
    }

    @Test
    public void testDequeueSingleElement() throws QUnderflowException{
        nodePQ.enqueue(10);
        assertEquals(Integer.valueOf(10), nodePQ.dequeue());
        assertTrue(nodePQ.isEmpty());
    }

    @Test
    public void testDequeueMultipleElements() throws QUnderflowException{
        nodePQ.enqueue(1);
        nodePQ.enqueue(2);
        nodePQ.enqueue(3);
        assertEquals(Integer.valueOf(1), nodePQ.dequeue());
        assertFalse(nodePQ.isEmpty());
        assertEquals(Integer.valueOf(2), nodePQ.dequeue());
        assertFalse(nodePQ.isEmpty());
        assertEquals(Integer.valueOf(3), nodePQ.dequeue());
        assertTrue(nodePQ.isEmpty());
    }
}
