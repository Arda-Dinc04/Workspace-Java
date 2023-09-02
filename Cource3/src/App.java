import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        // throw new NullPointerException("TEST");
        try{
            System.out.print("Enter first num: ");
            int x = input.nextInt();

            System.out.print("Enter second num: ");
            int y = input.nextInt();

            System.out.println(x / y);
        }
        catch (ArithmeticException e) {
            System.out.println("Error at division!");
        }
        catch (NumberFormatException e1) {
            System.out.println("Given formats are not valid!");
        }
        catch (NullPointerException e2) {
            System.out.println("Numbers must be not-null");
        }
        catch (Exception e3) {
            System.out.println("Unknown error occurred!");
        }
        finally {
            System.out.println("Finally done!");
        }

        // System.out.println("Arda");

        // throw new MyCustomExecption("Test");
    }
}
