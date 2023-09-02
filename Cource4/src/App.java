import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int[] array = new int[20];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // Generates random numbers between 0 and 99
        }

        Arrays.sort(array);

        // Printing the array
        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.print("\n\nSelect a number to search: ");
        int targetNum = new Scanner(System.in).nextInt();

        System.out.println("Index of searched number: " + binarySearch(targetNum,array));
    }

    public static int binarySearch(int target, int[] arr){
        int min = 0;
        int max = arr.length-1;

        while(min!=max){            
            int mid = (max + min) / 2;  
            if(arr[mid] > target){
                max = mid -1;
            }
            else if(arr[mid] < target){
                min = mid+1;
            }
            else if(arr[mid] == target)
                return mid; 
                
        }
        return -1;
        
    }
}
