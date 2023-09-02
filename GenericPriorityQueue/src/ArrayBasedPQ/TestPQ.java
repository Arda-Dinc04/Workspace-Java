package ArrayBasedPQ;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPQ {
    private ArrayPQ<Integer> pq;

    @Before
    public void setUp() {
        pq = new ArrayPQ<>(5);
    }

    @Test
    public void testEmptyQueue() {
        assertTrue(pq.isEmpty());
        assertFalse(pq.isFull());
    }

    @Test(expected = PQUnderflowException.class)
    public void testDequeueEmptyQueue() throws PQUnderflowException {
        pq.dequeue();
    }

    @Test
    public void testEnqueueDequeueSingleElement() throws PQOverflowException, PQUnderflowException {
        pq.enqueue(10);
        assertEquals(Integer.valueOf(10), pq.dequeue());
        assertTrue(pq.isEmpty());
    }

    @Test
    public void testFillQueue() throws PQOverflowException {
        for (int i = 1; i <= 5; i++) {
            pq.enqueue(i);
        }
        assertTrue(pq.isFull());
    }

    @Test(expected = PQOverflowException.class)
    public void testOverflowQueue() throws PQOverflowException {
        for (int i = 1; i <= 5; i++) {
            pq.enqueue(i);
        }
        pq.enqueue(6); // this should throw PQOverflowException
    }

    @Test
    public void testDequeueAllElements() throws PQOverflowException, PQUnderflowException {
        
        pq.enqueue(2);
        pq.enqueue(5);
        pq.enqueue(4);
        pq.enqueue(1);
        pq.enqueue(3);

        for (int i = 5; i >= 1; i--) {
            assertEquals(Integer.valueOf(i), pq.dequeue());
        }
        assertTrue(pq.isEmpty());
    }
}
