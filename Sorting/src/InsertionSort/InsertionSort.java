package InsertionSort;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int arr[]) {
        
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
        
        
    }

    public static void main(String[] args) {
        int[] data = { 9, 5, 1, 4, 3 };
        InsertionSort is = new InsertionSort();
        sort(data);
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(data));
        
    }

}
