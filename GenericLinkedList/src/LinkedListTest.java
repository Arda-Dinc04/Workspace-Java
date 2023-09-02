import org.junit.*;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList<Integer> linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new LinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
        linkedList = null;
    }

    @Test
    public void testAppend() {
        assertNull(linkedList.head);
        linkedList.append(1);
        assertEquals(Integer.valueOf(1), linkedList.head.value);
        linkedList.append(2);
        assertEquals(Integer.valueOf(2), linkedList.head.nextNode.value);
        linkedList.append(3);
        assertEquals(Integer.valueOf(3), linkedList.head.nextNode.nextNode.value);
    }

    @Test
    public void testPrepend() {
        assertNull(linkedList.head);
        linkedList.prepend(1);
        assertEquals(Integer.valueOf(1), linkedList.head.value);
        linkedList.prepend(2);
        assertEquals(Integer.valueOf(2), linkedList.head.value);
    }

    @Test
    public void testDelete() {
        assertNull(linkedList.head);
        try {
            linkedList.delete(1);
            fail();
        } catch (EmptyListException e) {
            assertEquals("List is Empty", e.getMessage());
        }
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        try {
            linkedList.delete(1);
            assertEquals(Integer.valueOf(2), linkedList.head.value);
            linkedList.delete(2);
            assertEquals(Integer.valueOf(3), linkedList.head.value);
            linkedList.delete(3);
            assertNull(linkedList.head);
        } catch (EmptyListException e) {
            fail();
        }
    }

    @Test
    public void testContains() {
        assertFalse(linkedList.contains(1));
        linkedList.append(2);
        linkedList.append(3);
        assertTrue(linkedList.contains(2));
        assertTrue(linkedList.contains(3));
        try {
            linkedList.delete(2);
            assertFalse(linkedList.contains(2));
        } catch (EmptyListException e) {
            fail();
        }
    }

    @Test
    public void testIsEmpty() {
        assertTrue(linkedList.isEmpty());
        linkedList.append(1);
        assertFalse(linkedList.isEmpty());
        try {
            linkedList.delete(1);
            assertTrue(linkedList.isEmpty());
        } catch (EmptyListException e) {
            fail();
        }
    }

    @Test
    public void testIndexOf() {
        try {
            linkedList.indexOf(5);
            fail();
        } catch (EmptyListException e) {
            assertEquals("List is Empty", e.getMessage());
        }
        linkedList.append(10);
        try {
            assertEquals(0, linkedList.indexOf(10));
            linkedList.append(3);
            linkedList.append(7);
            assertEquals(2, linkedList.indexOf(7));
            linkedList.delete(7);
            assertEquals(-1, linkedList.indexOf(7));
        } catch (EmptyListException e) {
            fail();
        }
    }

    @Test
    public void testGet() {
        linkedList.append(15);
        linkedList.append(5);
        linkedList.append(35);
        try {
            assertEquals(Integer.valueOf(35), linkedList.get(2));
            linkedList.delete(35);
            assertEquals(Integer.valueOf(5), linkedList.get(1));
        } catch (IndexOutOfBoundsException | EmptyListException e) {
            fail();
        }
    }

    @Test
    public void testGetFirst(){
        assertNull(linkedList.head);
        
        try {
            linkedList.getFirst();
            fail();
        } catch (EmptyListException e) {
            assertEquals("List is empty", e.getMessage());
        }

        linkedList.append(1);
        try {
            assertEquals(Integer.valueOf(1), linkedList.getFirst());
            linkedList.delete(1);
        } catch (EmptyListException e) {
            fail();
        }

        try {
            linkedList.getFirst();
            fail();
        } catch (EmptyListException e) {
            assertEquals("List is empty", e.getMessage());
        }
    }

    @Test
    public void testGetLast(){
        assertNull(linkedList.head);
        
        try {
            linkedList.getLast();
            fail();
        } catch (EmptyListException e) {
            assertEquals("List is empty", e.getMessage());
        }

        linkedList.append(1);
        try {
            assertEquals(Integer.valueOf(1), linkedList.getLast());
            linkedList.append(2);
            assertEquals(Integer.valueOf(2), linkedList.getLast());
            linkedList.append(3);
            assertEquals(Integer.valueOf(3), linkedList.getLast());
        } catch (EmptyListException e) {
            fail();
        }
        
        try {
            linkedList.delete(3);
            assertEquals(Integer.valueOf(2), linkedList.getLast());
            linkedList.delete(2);
            assertEquals(Integer.valueOf(1), linkedList.getLast());
            linkedList.delete(1);    
        } catch (EmptyListException e) {
            fail();
        }

        try {
            linkedList.getLast();
            fail();
        } catch (EmptyListException e) {
            assertEquals("List is empty", e.getMessage());
        }
    }
}
