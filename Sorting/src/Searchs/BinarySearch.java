package Searchs;

public class BinarySearch {



    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println("Trying to find index of 4: "+ search(arr, 4));
    }

    public static int search(int[] arr, int value){
        int start = 0, end = arr.length -1;
       while(start != end){
            int m = start = (end-start)/2;
            if(arr[m] == value)
                return m;
            else if(arr[m] >= value){
                end = m-1;
            }
            else{
                start = m+1;
            }
       }
       return -1;
    }

}
