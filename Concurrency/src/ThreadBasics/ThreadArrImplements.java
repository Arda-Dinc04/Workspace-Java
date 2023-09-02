package ThreadBasics;
public class ThreadArrImplements implements Runnable {

    int[] arr;
    int start, end;

    ThreadArrImplements(int start, int end, int[] arr) {
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
        // int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        // Thread th1 = new Thread(new ThreadArrImplements(0, 10, arr));
      
        // Thread th2 = new Thread(new ThreadArrImplements(0, 10, arr));
        // th1.start();
        // th2.start();
        // th1.join();
        // th2.join();

        // new Thread(new Runnable(){
        //     @Override
        //     public void run() {
        //         for (int i = 0; i < 10; i++) {
        //             System.out.println(Thread.currentThread().getName() + ": " +i);

        //             try {
        //                 Thread.sleep(500);

        //             } catch (Exception e) {
        //                 // TODO: handle exception
        //             }
        //         }
        //     }
        // }).start();

        // new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         for (int i = 10; i < 20; i++) {
        //             System.out.println(Thread.currentThread().getName() + ": " + i);

        //             try {
        //                 Thread.sleep(500);

        //             } catch (Exception e) {
        //                 // TODO: handle exception
        //             }
        //         }
        //     }
        // }).start();
    }

}
