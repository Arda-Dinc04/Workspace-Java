import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("John");
        list.add("Arda");
        list.add("Ayberk");
        list.add("Sara");
        list.add("Tom");
        list.add("Jane");

        // Get the iterator
        Iterator<String> it = list.iterator();

        // Print all elements
        System.out.println("List Elements: ");
        while (it.hasNext()) {
            System.out.print(it.next() +" ");
        }

        // Reset iterator
        it = list.iterator();
        
        // Remove an element
        while (it.hasNext()) {
            String name = it.next();
            if(name.contains("Tom"))
                it.remove();
        }

        it = list.iterator();
        // Print all elements
        System.out.println("\nList Elements: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
