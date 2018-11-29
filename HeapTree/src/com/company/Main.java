package com.company;

public class Main {

    public static void main(String[] args) {
//        int[] numbers = {10, 15, 20, 17, 25};
        int[] numbers = {25, 20, 10, 17, 15};

        HeapTreeArray<Integer> tree = new HeapTreeArray<>();

        tree.buildHeap(numbers);

        tree.print();
    }
}
