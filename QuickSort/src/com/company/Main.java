package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {20, 520, 1, 102, 2, 55, 5, 128, 4, 27, 30, 47, 99, 3};
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }


    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = partition(arr, start, end); // return partitioned index
            quickSort(arr, start, middle - 1);
            quickSort(arr, middle + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int partitionIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[partitionIndex];
                arr[partitionIndex] = arr[i];
                arr[i] = temp;
                partitionIndex++;
            }
        }
        int temp = arr[partitionIndex];
        arr[partitionIndex] = arr[end];
        arr[end] = temp;
        return partitionIndex;
    }

    public static void printArray (int[] arr) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


}
