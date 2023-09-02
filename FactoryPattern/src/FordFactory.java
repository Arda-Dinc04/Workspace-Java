public class FordFactory extends Factory{

    @Override
    public Engine createEngine() {
       return new FordEngine(20000);
    }

    @Override
    public Transmission createTransmission() {
        return new FordTransmission(12000);
    }
   
 
}
