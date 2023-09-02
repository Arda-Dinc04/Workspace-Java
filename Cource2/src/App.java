import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Animal dog = new Dog();
        Animal animal = new Animal();
        Animal cat = new Cat();

        // System.out.println(dog instanceof Dog);
        // System.out.println(dog instanceof Animal);

        Animal[] arr = new Animal[] {dog,animal,cat};
        for(Animal a : arr){
            a.makeSound();
        }
    }
}