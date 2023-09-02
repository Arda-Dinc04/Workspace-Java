public class OpelFactory extends Factory{
    
    @Override
    public Engine createEngine() {
       return new OpelEngine(25000);
    }

    @Override
    public Transmission createTransmission() {
        return new OpelTransmission(10000);
    }
   
}
