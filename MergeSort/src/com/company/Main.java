package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 1, 0};
        printArray(arr, 0, arr.length - 1);
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr,mid + 1, right);
            merge(arr, left, mid + 1, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int [] temp = new int[right - left + 1];
        int tempCounter = 0, i = left, j = mid;
        while (temp[temp.length - 1] == 0) {
            System.out.println(temp[temp.length - 1]);
            System.out.println();
            if (arr[i] <= arr[j]) {
                temp[tempCounter] = arr[i];
                i++;
            } else {
                temp[tempCounter] = arr[j];
                j++;
            }
            tempCounter++;
        }
//        printArray(temp, 0, temp.length - 1);
        tempCounter = 0;
        for (int k = left; k <= right; k++) {
            arr[k] = temp[tempCounter++];
        }
//        printArray(arr, left, right);
//        printArray(arr, right, arr.length - 1);
//        System.out.println();
    }

    public static void printArray (int[] arr, int left, int right) {
        for (int i = left; i <= right; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }

}
