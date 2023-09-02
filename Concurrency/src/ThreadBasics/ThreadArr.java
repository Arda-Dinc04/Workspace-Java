package ThreadBasics;
public class ThreadArr extends Thread {

    int[] arr;
    int start, end;

    ThreadArr(int start, int end, int[] arr) {
        this.start = start;
        this.end = end;
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + arr[i] + " ");
            
            try {
                Thread.sleep(500);

            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        Thread th1 = new ThreadArr(0, 10, arr);
        System.out.println();
        Thread th2 = new ThreadArr(10, 20, arr);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
    }

}
