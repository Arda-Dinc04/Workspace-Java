import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {

        
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                Database db1 = Database.getInstance();

                db1.buy("Apple", 1);
                db1.buy("Cherry", 1);

                db1.buy("Blueberry", 1);
                db1.buy("Banana", 1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Database db1 = Database.getInstance();

                db1.buy("Apple", 1);
                db1.buy("Cherry", 1);

                db1.buy("Blueberry", 1);
                db1.buy("Banana", 1);
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                Database db1 = Database.getInstance();

                db1.buy("Apple", 1);
                db1.buy("Cherry", 1);

                db1.buy("Blueberry", 1);
                db1.buy("Banana", 1);
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                Database db1 = Database.getInstance();

                db1.buy("Apple", 1);
                db1.buy("Cherry", 1);

                db1.buy("Blueberry", 1);
                db1.buy("Banana", 1);
            }
        });

        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                Database db1 = Database.getInstance();

                db1.buy("Apple", 1);
                db1.buy("Cherry", 1);

                db1.buy("Blueberry", 1);
                db1.buy("Banana", 1);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("After Inv:");
        Database db1 = Database.getInstance();
        db1.printInventory();
    }
    
}
