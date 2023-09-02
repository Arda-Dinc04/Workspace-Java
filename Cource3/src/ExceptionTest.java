class CustomException1 extends Exception {
    public CustomException1(String msg) {
        super(msg);
    }
}

class CustomException2 extends Exception {
    public CustomException2(String msg) {
        super(msg);
    }
}

public class ExceptionTest {

    public static void main(String[] args) {
        try {
            try {
                try {
                    throw new CustomException1("Custom Exception 1");
                } catch (CustomException1 e) {
                    System.out.println(e.getMessage());
                    throw new CustomException2("Custom Exception 2");
                } finally {
                    System.out.println("Inner most finally block");
                }
            } catch (CustomException2 e) {
                System.out.println(e.getMessage());
                throw new RuntimeException("Runtime Exception");
            } finally {
                System.out.println("Middle finally block");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Outer most finally block");
        }
    }
}

//Custom Exception 1
//Inner most finally block
//Custom Exception 2
//Middle finally block
//Runtime Exception
//Outer most finally block