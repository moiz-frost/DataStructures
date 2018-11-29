package com.company;

import java.text.MessageFormat;

public class ArrayPriorityQueue <T extends Comparable<T>> {

    private T[] arrayQueue;
    int frontIndex;
    int size;

    public ArrayPriorityQueue(int size) {
        arrayQueue = (T[]) new Comparable[size];
        frontIndex = -1;
        this.size = size;
    }

    private void insertDescending(T data)
    {
        if (isEmpty()) {
            arrayQueue[0] = data;
            frontIndex = 0;
            return;
        }
        for (int i = frontIndex; i >= 0 ; i--) {
            if (arrayQueue[i].compareTo(data) > 0 || arrayQueue[i].compareTo(data) == 0) {
                arrayQueue[i + 1] = data;
                break;
            }
            if (arrayQueue[i].compareTo(data) < 0) {
                arrayQueue[i + 1] = arrayQueue[i];
                arrayQueue[i] = data;
            }
        }
        frontIndex++;
    }

    public void enqueue (T data) {
        if (isFull()) return;
        insertDescending(data);
    }

    public T dequeue () {
        T returnValue = arrayQueue[frontIndex];
        arrayQueue[frontIndex--] = null;
        return returnValue;
    }

    public boolean isEmpty () {
        return frontIndex == -1;
    }

    public boolean isFull () {
        return frontIndex == size - 1;
    }

    public void print () {
        System.out.print("\n");
        System.out.print("[");
        for (int i = 0; i <= frontIndex; i++) {
            if (arrayQueue[i] != null) {
                MessageFormat message = new MessageFormat(", {0}");
                Object[] args = {
                        arrayQueue[i]
                };
                System.out.print(message.format(args));
            }
        }
        System.out.print("]");
        System.out.print("\n");
    }

}
