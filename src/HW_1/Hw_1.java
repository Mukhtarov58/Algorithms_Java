package HW_1;

import java.util.Arrays;
import java.util.Random;

// Реализовать алгоритм пирамидальной сортировки (сортировка кучей).

public class Hw_1 {
    public static void main(String[] args) {
        int[] arr = new int[50];
        int[] arr2 = new int[50];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
            arr2[i] = arr[i];
        }
        heapSort(arr);
        System.out.println(Arrays.toString(arr));


    }
    public static void heapSort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            // Поменять местами и продолжить heapify
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}


