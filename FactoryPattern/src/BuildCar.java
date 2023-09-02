import java.util.ArrayList;

public class BuildCar {
    private ArrayList<Part> parts = new ArrayList<>();
    
    public void createCar(Factory factory){
        
        parts.add(factory.createEngine());
        parts.add(factory.createTransmission());
    }

    public void displayParts(){
        System.out.println("----Listing parts----");
        for (Part iterable_element : parts) {
            System.out.println(iterable_element.displayName() + " " + iterable_element.getPrice());
        }
    }
}
