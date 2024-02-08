package Sem_2;

import java.util.Arrays;
import java.util.Random;

public class Sem_2 {
    public static void main(String[] args) {
        int[] arr = new int[50];
        int[] arr2 = new int[50];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
            arr2[i] = arr[i];
        }

//        bubbleSort(arr);
        long start = System.currentTimeMillis();
        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
        long over = System.currentTimeMillis();
        System.out.println(over - start);

        start = System.currentTimeMillis();
        quickSort(arr2, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        over = System.currentTimeMillis();
        System.out.println(over - start);

        Arrays.sort(arr);
        System.out.println(search(arr[4], arr2, 0, arr2.length - 1));

    }

    public static int search(int value, int[] arr, int min, int max) {
        int mid;
        if (max < min) {
            return -1;
        } else {
            mid = (max - min) / 2 + min;
        }
        if (arr[mid] < value) {
            return search(value, arr, mid + 1, max);
        } else {
            if (arr[mid] > value) {
                return search(value, arr, min, mid - 1);
            } else {
                return mid;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    finish = false;
                }
            }
        } while (!finish);

    }

    public static void quickSort(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int p = arr[(start + end) / 2];
        do {
            while (arr[left] < p) {
                left++;
            }
            while (arr[right] > p) {
                right--;
            }
            if (left <= right) {
                if (left < right) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                left++;
                right--;
            }
        } while (left <= right);
//        System.out.println(left);
        if (left < end) {
            quickSort(arr, left, end);
        }
        if (start < right) {
            quickSort(arr, start, right);
        }
    }
}
