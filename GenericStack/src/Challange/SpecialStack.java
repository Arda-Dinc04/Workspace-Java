package Challange;

import NodeBasedStack.Stack;
import NodeBasedStack.StackUnderflowException;

public class SpecialStack<T extends Comparable<T>> {
    private NodeBasedStack.Stack<T> norm;
    private NodeBasedStack.Stack<T> minStack;
    T minValue;

    SpecialStack() {
        norm = new NodeBasedStack.Stack<>();
        minStack = new NodeBasedStack.Stack<>();
    }

    public void push(T data) throws StackUnderflowException {
        if (norm.isEmpty() || data.compareTo(minStack.peek()) <= 0) {
            minStack.push(data);
        }
        norm.push(data);

    }

    public T pop() throws StackUnderflowException {
        if (norm.peek().compareTo(minStack.peek()) == 0) {
            minStack.pop();
        }
        return norm.pop();
    }

    public T getMin() throws StackUnderflowException {
        return minStack.peek();
    }

}