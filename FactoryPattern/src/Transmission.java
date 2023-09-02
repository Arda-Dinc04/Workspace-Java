public abstract class Transmission extends Part {
    protected double price;
    protected String name;
    
    @Override
    public String displayName() {
        return name;
    }

    @Override
    public double getPrice() { 
        return price;
    }    
}