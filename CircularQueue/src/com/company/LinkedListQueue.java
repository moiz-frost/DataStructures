package com.company;

import java.text.MessageFormat;

public class LinkedListQueue <T extends Comparable<T>> {
    private Node<T> front;
    private Node<T> rear;

    public void enqueue (T data) {
        if (rear == null) {
            rear = new Node<T>(data);
            front = rear;
        } else {
            Node newNode = new Node<T>(data);
            rear.previous = newNode;
            newNode.next = rear;
            rear = newNode;
        }
    }

    public void print () {
        System.out.print("\n");
        System.out.print("[");
        Node currentPointer = rear;
        while (currentPointer != null) {
            MessageFormat message = new MessageFormat(", {0}");
            Object[] args = {
                    currentPointer.data
            };
            System.out.print(message.format(args));
            currentPointer = currentPointer.next;
        }
        System.out.print("]");
        System.out.print("\n");
    }


    public T dequeue() {
        Node<T> dequeue = front;
        front = front.previous;
        if (front != null) front.next = null;
        else rear = null;
        return dequeue.data;
    }

    public boolean isEmpty() {
        return false;
    }
}
