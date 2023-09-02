import java.util.HashMap;
import java.util.Map;

public class Database {
    public HashMap<String, Integer> fruits;
    private static Database instance;

    private Database(){
        fruits = new HashMap<>();
        fruits.put("Apple", 10);
        fruits.put("Banana", 10);
        fruits.put("Cherry", 10);
        fruits.put("Strawberry", 10);
        fruits.put("Blueberry", 10);
    }

    public static Database getInstance() {
        if(instance == null)
            instance = new Database();
        return instance;
    }

    public void buy(String fruit, int amount) {
        if (amount <= fruits.get(fruit)) {
            fruits.put(fruit, fruits.get(fruit) - amount);
            return;
        }
        System.out.println("Not enough inventory!");
        
    }

    public void printInventory() {
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            System.out.println("Object: " + entry.getKey() + "\tValue: "+ entry.getValue());
        }
            
    }
}
