package com.company;
import java.text.MessageFormat;
import java.util.Arrays;

public class ArrayListStack {

    private int[] array;
    private int arraySize = 10;
    private int indexPointer = 0;

    public ArrayListStack() {
        array = new int[arraySize];
    }

    public void push(int data) {
        if (array.length > arraySize) {
            increaseArraySize();
        }
        array[indexPointer++] = data;
    }

    public int pop() {
        return array[indexPointer--];
    }

    public void print () {
        System.out.print("\n");
        System.out.print("[");
        for (int i = 0; i < indexPointer; i++) {
            MessageFormat message = new MessageFormat(", {0}");
            Object[] args = {
                    array[i]
            };
            System.out.print(message.format(args));
        }
        System.out.print("]");
        System.out.print("\n");
    }

    private void increaseArraySize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    public int size() {
        return indexPointer;
    }

    public boolean isEmpty() {
        return indexPointer == 0;
    }
}
