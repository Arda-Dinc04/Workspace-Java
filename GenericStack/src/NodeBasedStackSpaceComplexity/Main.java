package NodeBasedStackSpaceComplexity;



/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws NodeBasedStackSpaceComplexity.StackUnderflowException {
        StackSpace<Integer> specialStack = new StackSpace<>();

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
    }
}