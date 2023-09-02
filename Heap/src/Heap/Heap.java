package Heap;

import java.util.ArrayList;

public class Heap {
    

    public void heapify(ArrayList<Integer> arr, int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left < arr.size() && arr.get(left) > arr.get(largest)){
            largest = left;
        }
        else if(right < arr.size() && arr.get(right) > arr.get(largest)){
            largest = right;
        }

        if(largest != i){
           int temp =  arr.get(i);
           arr.set(i, arr.get(largest));
           arr.set(largest, temp);

           heapify(arr, largest);
        }
    }

    public void insert(ArrayList<Integer> arr, int value){
        if(arr.isEmpty()){
            arr.add(value);
        }
        else{
            arr.add(value);
            for (int i = arr.size() / 2 - 1; i >= 0; i--) {
                heapify(arr, i);
            }
        }
    }

    // Select the element to be deleted.
    // Swap it with the last element
    // Remove the last element.
    // Heapify the tree.


    public void delete(ArrayList<Integer> arr, int value){
        if (arr.isEmpty()) {
            return;
        }
        int i;
        for (i = 0; i < arr.size(); i++) {
            if(arr.get(i) == value){
                break;
            }
        }

        arr.set(i, arr.get(arr.size()-1));
        arr.remove(arr.size()-1);

        for (int j = arr.size() / 2 - 1; j >= 0; j--) {
            heapify(arr, j);
        }
    }

    void printArray(ArrayList<Integer> array, int size) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {

        ArrayList<Integer> array = new ArrayList<Integer>();
        int size = array.size();

        Heap h = new Heap();
        h.insert(array, 3);
        h.insert(array, 4);
        h.insert(array, 9);
        h.insert(array, 5);
        h.insert(array, 2);

        System.out.println("Max-Heap array: ");
        h.printArray(array, size);

        h.delete(array, 4);
        System.out.println("After deleting an element: ");
        h.printArray(array, size);
    }
}
