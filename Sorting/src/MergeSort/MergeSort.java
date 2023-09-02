package MergeSort;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int start, int end, int[] arr) {
        if (start < end) {
            int mid = (end + start) / 2;
            sort(start, mid, arr);
            sort(mid + 1, end, arr);

            merge(arr, start, end, mid);
        }
    }

    public static void merge(int[] arr, int start, int end, int mid) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[start + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String args[]) {
        int arr[] = { 6, 5, 12, 10, 9, 1 };

        sort(0, arr.length - 1, arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
