package Challange;

import NodeBasedStack.StackUnderflowException;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        SpecialStack<Integer> specialStack = new SpecialStack<>();

        try {
            specialStack.push(6);
            System.out.println("MIN: " + specialStack.getMin());

            specialStack.push(7);
            System.out.println("MIN: " + specialStack.getMin());

            specialStack.push(8);
            System.out.println("MIN: " + specialStack.getMin());

            specialStack.push(5);
            System.out.println("MIN: " + specialStack.getMin());

            specialStack.push(3);
            System.out.println("MIN: " + specialStack.getMin());

            specialStack.pop();
            System.out.println("MIN: " + specialStack.getMin());

            specialStack.push(10);
            System.out.println("MIN: " + specialStack.getMin());

            specialStack.pop();
            System.out.println("MIN: " + specialStack.getMin());

            specialStack.pop();
            System.out.println("MIN: " + specialStack.getMin());

        } catch (StackUnderflowException e) {
            System.out.println("EXCEPTION");
        }
    }
}