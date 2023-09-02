import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        Map<String, Integer> myMap = new HashMap<>();

        myMap.put("Apple", 10);
        myMap.put("Apple", 20);
        myMap.put("Banana", 20);
        myMap.put("Cherry", 30);
    
        int appleCount = myMap.get("Apple"); // 10
        System.out.println("AppleCount = " + appleCount);
        Integer count = myMap.get("Orange"); // null
        System.out.println("Count = " + count);

        // To check if a map contains a key

        if (myMap.containsKey("Apple")) {
            System.out.println("We got some apples");
        }

        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        myMap.remove("Apple");

        System.out.println("--------------------");

        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
