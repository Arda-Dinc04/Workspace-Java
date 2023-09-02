public class App {
    public static void main(String[] args) throws Exception {
        FordFactory ford = new FordFactory();
        OpelFactory opel = new OpelFactory();
        BuildCar builder = new BuildCar();

        System.out.println("Creating FORD");
        builder.createCar(ford);
        builder.displayParts();

        System.out.println("\n\nCreating OPEL");
        builder.createCar(opel);
        builder.displayParts();

        System.out.println("\n\nCreating OPEL");
        builder.createCar(opel);
        builder.displayParts();
        

    }
}
