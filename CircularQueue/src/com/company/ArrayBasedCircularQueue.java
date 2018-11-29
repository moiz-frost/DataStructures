package com.company;

import java.text.MessageFormat;

public class ArrayBasedCircularQueue <T> {

    private T[] arrayQueue;
    int frontIndex, rearIndex;
    int size;

    public ArrayBasedCircularQueue(int size) {
        arrayQueue = (T[]) new Object[size];
        frontIndex = rearIndex = arrayQueue.length - 1;
        this.size = size;
    }

    public void enqueue (T data) {
        if (isFull()) return;
        rearIndex = (rearIndex + 1) % size;
        arrayQueue[rearIndex] = data;
    }

    public T dequeue () {
        if (isEmpty()) return null;
        frontIndex = (frontIndex + 1) % size;
        T dequeue = arrayQueue[frontIndex];
        arrayQueue[frontIndex] = null;
        return dequeue;
    }

    public boolean isFull() {
        return ((rearIndex + 1) % size) == frontIndex;
    }

    public boolean isEmpty() {
        return frontIndex == rearIndex;
    }

    public void print () {
        System.out.print("\n");
        System.out.print("[");
        for (int i = 0; i < size; i++) {
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
