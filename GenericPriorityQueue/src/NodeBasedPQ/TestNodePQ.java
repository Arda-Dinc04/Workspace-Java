package NodeBasedPQ;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestNodePQ {

    private NodePQ<Integer> nodePQ;

    @Before
    public void setUp() {
        nodePQ = new NodePQ<>();
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(nodePQ.isEmpty());
    }

    @Test
    public void testEnqueueSingleElement() {
        nodePQ.enqueue(5);
        assertFalse(nodePQ.isEmpty());
    }

    @Test
    public void testEnqueueMultipleElements() {
        nodePQ.enqueue(3);
        nodePQ.enqueue(1);
        nodePQ.enqueue(2);
        assertFalse(nodePQ.isEmpty());
    }

    @Test(expected = PQUnderflowException.class)
    public void testDequeueFromEmptyQueue() throws PQUnderflowException {
        nodePQ.dequeue();
    }

    @Test
    public void testDequeueSingleElement() throws PQUnderflowException {
        nodePQ.enqueue(10);
        assertEquals(Integer.valueOf(10), nodePQ.dequeue());
        assertTrue(nodePQ.isEmpty());
    }

    @Test
    public void testDequeueMultipleElementsOrdered() throws PQUnderflowException {
        nodePQ.enqueue(1);
        nodePQ.enqueue(3);
        nodePQ.enqueue(2);
        assertEquals(Integer.valueOf(3), nodePQ.dequeue());
        assertEquals(Integer.valueOf(2), nodePQ.dequeue());
        assertEquals(Integer.valueOf(1), nodePQ.dequeue());
        assertTrue(nodePQ.isEmpty());
    }

    @Test
    public void testMixedEnqueueDequeue() throws PQUnderflowException {
        nodePQ.enqueue(5);
        assertEquals(Integer.valueOf(5), nodePQ.dequeue());
        assertTrue(nodePQ.isEmpty());
        nodePQ.enqueue(3);
        nodePQ.enqueue(4);
        assertEquals(Integer.valueOf(4), nodePQ.dequeue());
        assertFalse(nodePQ.isEmpty());
        nodePQ.enqueue(9);
        assertEquals(Integer.valueOf(9), nodePQ.dequeue());
        assertEquals(Integer.valueOf(3), nodePQ.dequeue());
        assertTrue(nodePQ.isEmpty());
    }
}
