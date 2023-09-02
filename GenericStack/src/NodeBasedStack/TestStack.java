package NodeBasedStack;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestStack {
    Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
    }

    @After
    public void tearDown() {
        stack = null;
    }

    @Test
    public void testPush() {
        assertNull(stack.top);
        stack.push(1);
        assertEquals(stack.top.value, Integer.valueOf(1));
        stack.push(2);
        assertEquals(stack.top.value, Integer.valueOf(2));
        stack.push(5);
        assertEquals(stack.top.value, Integer.valueOf(5));
    }

    @Test
    public void testPop() {
        try {
            stack.pop();
            fail();
        } catch (StackUnderflowException e) {
            assertEquals("Stack is Empty!", e.getMessage());
        }

        try {
            stack.push(5);
            stack.push(10);
            stack.push(133);

            assertEquals(Integer.valueOf(133), stack.pop());
            assertEquals(Integer.valueOf(10), stack.pop());
            assertEquals(Integer.valueOf(5), stack.pop());
        } catch (StackUnderflowException e) {
            fail();
        }

        try {
            stack.pop();
            fail();
        } catch (StackUnderflowException e) {
            assertEquals("Stack is Empty!", e.getMessage());
        }
    }

    @Test
    public void testPeek() {
        try {
            stack.peek();
            fail();
        } catch (StackUnderflowException e) {
            assertEquals("Stack is Empty!", e.getMessage());
        }

        try {
            stack.push(5);
            assertEquals(Integer.valueOf(5), stack.peek());
            stack.push(11);
            assertEquals(Integer.valueOf(11), stack.peek());
            stack.push(21);
            assertEquals(Integer.valueOf(21), stack.peek());
            stack.pop();
            assertEquals(Integer.valueOf(11), stack.peek());
        } catch (StackUnderflowException e) {
            fail();
        }
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());

        stack.push(17);
        assertEquals(1, stack.size());
        stack.push(55);
        assertEquals(2, stack.size());
        stack.push(77);
        assertEquals(3, stack.size());

        try {
            stack.pop();
            assertEquals(2, stack.size());
            stack.pop();
            assertEquals(1, stack.size());
            stack.pop();
            assertEquals(0, stack.size());

        } catch (StackUnderflowException e) {
            fail();
        }
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        try {
            stack.push(1);
            assertFalse(stack.isEmpty());
            stack.pop();
            assertTrue(stack.isEmpty());
        } catch (StackUnderflowException e) {
            fail();
        }
    }

    @Test
    public void testClear() {
        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);
        assertEquals(4, stack.size());
        stack.clear();
        assertEquals(0, stack.size());
    }
}
