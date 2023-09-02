package PhilosphersProblem;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {


        Philospher[] arrPh = new Philospher[5];
        
        Fork[] arr = new Fork[5];
        for (int i = 0; i < arr.length; i++) {
             arr[i] = new Fork(i+1);
        }
        
        for (int i = 0; i < arr.length; i++) {
            arrPh[i] = new Philospher(arr[i], arr[(i+1)%arrPh.length]);
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
