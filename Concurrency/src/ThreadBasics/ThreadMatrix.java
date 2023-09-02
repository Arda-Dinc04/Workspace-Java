package ThreadBasics;
public class ThreadMatrix extends Thread {
    int start, end;
    int[][] arr;
    float[] avgArr;
    

    ThreadMatrix(int[][] arr, int start, int end, float[] avgArr) {
        this.start = start;
        this.end = end;
        this.arr = arr;
        this.avgArr = avgArr;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            int avgSum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                avgSum += arr[i][j];
            }
            avgArr[i] = (float)avgSum/arr[i].length;
        }
    }
}