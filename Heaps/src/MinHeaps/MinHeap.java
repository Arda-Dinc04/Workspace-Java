package MinHeaps;
public class MinHeap {
    int[] arr;

    MinHeap(){
        arr = new int[] {10,1,3,9,27};
    }

    public void sort(){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        MinHeap ob = new MinHeap();
        System.out.println(ob.toString());
        ob.sort();
        System.out.println(ob.toString());
    }

    @Override
    public String toString(){
        String str = "Array: ";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i]+", ";
        }
        return str+"\n";
    }
}
