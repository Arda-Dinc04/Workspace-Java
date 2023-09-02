package PhilospherPorblemWithTime;

public class Main {


    public static void main(String[] args) {


        Philospher[] arrPh = new Philospher[5]; 
        Fork[] arr = new Fork[5];
        for (int i = 0; i < arr.length; i++) {
             arr[i] = new Fork(i+1);
        }
        
        // arrPh[0] = new Philospher(arr[1], arr[0]);
        for (int i = 0; i < arr.length; i++) {
            arrPh[i] = new Philospher(arr[i], arr[(i+1)%arrPh.length], ("Philosopher-"+i));
        }
        
       
       
        for (Philospher ph : arrPh) {
            ph.start();
        }

        try {
            for (Philospher ph : arrPh) {
                ph.join();
            }
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }
}
