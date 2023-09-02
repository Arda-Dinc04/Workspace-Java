package ThreadBasics;
import java.util.Arrays;
import java.util.Random;

public class App {
    
    public static void main(String[] args) throws Exception {
        int[][] arr = generateMatrix();
        float[] avgArr = new float[400];
        
        Thread th1 = new ThreadMatrix(arr,0,100, avgArr); // 0-100
        Thread th2 = new ThreadMatrix(arr,100,200, avgArr); // 100-200
        Thread th3 = new ThreadMatrix(arr,200,300, avgArr); // 200-300
        Thread th4 = new ThreadMatrix(arr,300,400, avgArr); // 300-400

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        
        th1.join();
        th2.join();
        th3.join();
        th4.join();
        

        for (int i = 0; i < 400; i++) {
            System.out.println(i +" : " + avgArr[i]);
        }
    }

    public static int[][] generateMatrix(){
        Random rn = new Random();
        int[][] arr = new int[400][400];
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 400; j++) {
                arr[i][j] = rn.nextInt(100);
            }
        }
        return arr;
    }
}
