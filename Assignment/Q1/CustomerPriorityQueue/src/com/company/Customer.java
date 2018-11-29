package com.company;

import java.text.MessageFormat;

public class Customer {

    private int[] arrayQueue;
    int frontIndex;
    int size;
    int currentId = 0;

    public Customer(int size) {
        arrayQueue = new int[size];
        for (int i = 0; i < arrayQueue.length; i++) {
            arrayQueue[i] = -1;
        }
        frontIndex = -1;
        this.size = size;
    }

    private void insertDescending(int data)
    {
        if (isEmpty()) {
            arrayQueue[0] = data;
            frontIndex = 0;
            return;
        }
        for (int i = frontIndex; i >= 0 ; i--) {
            if (arrayQueue[i] > (data) || arrayQueue[i] == (data)) {
                arrayQueue[i + 1] = data;
                break;
            }
            if (arrayQueue[i] < data) {
                arrayQueue[i + 1] = arrayQueue[i];
                arrayQueue[i] = data;
            }
        }
        frontIndex++;
    }

    public void CustomerEnter () {

        if (isFull()) return;
        insertDescending(currentId++);
    }

    public int ServeCustomer () {
        int returnValue = arrayQueue[frontIndex];
        arrayQueue[frontIndex--] = -1;
        return returnValue;
    }

    public boolean isEmpty () {
        return frontIndex == -1;
    }

    public String HomeDelivery () {
        return frontIndex == -1 ? "Gulshan Iqbal, Block-6" : "Queue not empty";
    }

    public boolean isFull () {
        return frontIndex == size - 1;
    }

    public boolean CancelAll () {
        for (int i = 0; i < arrayQueue.length; i++) {
            arrayQueue[i] = -1;
        }
        frontIndex = -1;
        return true;
    }

    public void ShowAll () {
        System.out.print("\n");
        System.out.print("[");
        for (int i = 0; i <= frontIndex; i++) {
            if (arrayQueue[i] != -1) {
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
