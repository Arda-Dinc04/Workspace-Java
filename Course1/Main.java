package Course1;


class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

class Dog extends Animal {
    void eat() {
        System.out.println("Dog is eating...");
    }
    void bark() {
        System.out.println("Dog is barking...");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog(); // The object is actually a Dog
        a.eat();  // This is fine
        ((Dog)a).bark();  // This is also fine because a is actually a Dog
    }
}
