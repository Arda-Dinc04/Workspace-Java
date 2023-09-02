class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}

class Base {
    void method() throws MyException {
        throw new MyException("Base Exception");
    }
}

class Derived extends Base {
    @Override
    void method() throws MyException {
        try {
            super.method();
        } catch (MyException e) {
            System.out.println(e.getMessage());
            throw new MyException("Derived Exception");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Base b = new Derived();
        try {
            b.method();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
//Base Exception
//Derived Exception