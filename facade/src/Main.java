/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws Exception {
        
        Morgage facade = new Morgage();
        if (facade.check(1000, "Arda", 10000)) {
            System.out.println("OK");
        }
        else
            System.out.println("ERROR");
    }
}