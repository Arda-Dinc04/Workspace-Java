package SelectionSort;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import BubbleSort.BubbleSort;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 6; i++) {
            int num = (int) Math.pow(10, i);
            int arr[] = randomArrGenrator(num);

            Date sTime = new Date();
            Selection.selectionSort(arr);
            Date eTime = new Date();
            long passedTime = eTime.getTime() - sTime.getTime();
            printToFile("Sorting " + num + " elements took: " + passedTime + "ms\n");   
        }
        System.out.println("Printed to file.");
    }

    public static int[] randomArrGenrator(int total) {
        Random rand = new Random();
        int[] array = new int[total];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt();
        }
        return array;
    }

    public static void printToFile(String txt) throws IOException {
        FileWriter writer = new FileWriter("src/SelectionSort/output.txt", true);
        writer.write(txt);
        writer.close();
    }
}   