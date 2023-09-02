package Searchs;

public class Linear {
    


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        System.out.println("Trying to find index of 4: "+ search(arr, 4));
    }

    public static int search(int[] arr, int value){
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == value)
                    return i;
            }
            return -1;
    }
}
